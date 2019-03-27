package mappers;

import domain.model.*;
import repository.entity.*;
import util.Tuple;

import java.util.ArrayList;
import java.util.Collection;

public class ModelToHibernate {
    public static Tuple<UserEntity, Collection<UserRoleEntity>> getUserEntity(User user) {
        // create UserEntity without roles
        UserEntity userEntity;

        // create new user
        if (user.getID()==0){
            userEntity = new UserEntity(
                    user.getLogin(),
                    user.getPassword(),
                    user.getName(),
                    user.getAge());
        } else {
            // update existing user
            userEntity = new UserEntity(
                    user.getID(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getName(),
                    user.getAge());
        }
        
        // get role list from the domain user model
        Collection<UserRoleEntity> userRoles = new ArrayList<>();

        // TODO: 16.03.2019 redo role (so it doesn't depend on the name)
        // generate id for roleEntity based on the name of the role
        for (Role role : user.getRoles()) {
            long id = 0;
            if (role.getName() == "user") {
                id = RoleEntity.USER;
            } else if (role.getName() == "teacher") {
                id = RoleEntity.TEACHER;
            } else if (role.getName() == "admin") {
                id = RoleEntity.ADMIN;
            }

            RoleEntity roleEntity = new RoleEntity(id, role.getName());

            // userRoleEntity initialized with current user(without id) and role
            // user is updated after we get it's id from database
            userRoles.add(new UserRoleEntity(userEntity, roleEntity, role.getRating()));
        }
        return new Tuple<>(userEntity, userRoles);
    }

    public static LectureEntity getLectureEntity(Lecture lecture){
        UserEntity userEntity = ModelToHibernate.getUserEntity(lecture.getTeacher()).getX();

        LectureEntity lecture_ =  new LectureEntity(
                lecture.getID(),
                lecture.getName(),
                lecture.getDate().toString(),
                lecture.getDescription(),
                lecture.getLength(),
                userEntity);
        for (ButtonEvent buttonEvent: lecture.getButtonEvents()) {
            lecture_.getButtonEventsById().add(getButtonEventEntity(buttonEvent));
        }

        for (CommentEvent commentEvent : lecture.getCommentEvents()) {
            lecture_.getCommentEventsById().add(getCommentEventEntity(commentEvent));
        }

        return lecture_;
    }

    public static CommentEventEntity getCommentEventEntity(CommentEvent commentEvent){
        UserEntity userEntity = ModelToHibernate.getUserEntity(commentEvent.getUser()).getX();
        LectureEntity lectureEntity = ModelToHibernate.getLectureEntity(commentEvent.getLecture());

        return new CommentEventEntity(
                commentEvent.getID(),
                commentEvent.getTime(),
                commentEvent.getText(),
                lectureEntity,
                userEntity);
    }

    public static ButtonEventEntity getButtonEventEntity(ButtonEvent buttonEvent){
        UserEntity userEntity = ModelToHibernate.getUserEntity(buttonEvent.getUser()).getX();
        LectureEntity lectureEntity = ModelToHibernate.getLectureEntity(buttonEvent.getLecture());

        return new ButtonEventEntity(
                buttonEvent.getID(),
                buttonEvent.getTime(),
                buttonEvent.pressType().value(),
                lectureEntity,
                userEntity);
    }
}
