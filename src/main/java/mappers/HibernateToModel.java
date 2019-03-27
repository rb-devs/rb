package mappers;

import domain.Date;
import domain.model.*;
import repository.entity.*;

import java.util.ArrayList;
import java.util.Collection;

public class HibernateToModel {
    public static User getUser(UserEntity userEntity) {
        Collection<Role> roles = new ArrayList<Role>();
        for (UserRoleEntity userRole : userEntity.getUserRolesById()) {
            roles.add(new Role(userRole.getRoleEntity().getName(), userRole.getRating()));
        }
        return new User(
                userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getAge(),
                roles
        );
    }

    public static Lecture getLecture(LectureEntity lectureEntity) {
        Collection<ButtonEvent> buttonEvents = new ArrayList<>();
        Collection<CommentEvent> commentEvents = new ArrayList<>();
        for (ButtonEventEntity buttonEventEntity : lectureEntity.getButtonEventsById()) {
            buttonEvents.add(getButtonEvent(buttonEventEntity));
        }
        for (CommentEventEntity commentEventEntity : lectureEntity.getCommentEventsById()) {
            commentEvents.add(getCommentEvent(commentEventEntity));
        }
        return new Lecture(
                lectureEntity.getId(),
                getUser(lectureEntity.getUserByTeacherId()),
                lectureEntity.getName(),
                new Date(lectureEntity.getDate()),
                lectureEntity.getDescription(),
                lectureEntity.getLength(),
                buttonEvents,
                commentEvents
        );
    }

    public static ButtonEvent getButtonEvent(ButtonEventEntity buttonEventEntity) {
        return new ButtonEvent(
                buttonEventEntity.getId(),
                getLecture(buttonEventEntity.getLectureByLectureId()),
                getUser(buttonEventEntity.getUserByUserId()),
                buttonEventEntity.getTimeStamp(),
                getPressType(buttonEventEntity.getPressType())
        );
    }

    public static CommentEvent getCommentEvent(CommentEventEntity commentEventEntity) {
        return new CommentEvent(
                commentEventEntity.getId(),
                getLecture(commentEventEntity.getLectureByLectureId()),
                getUser(commentEventEntity.getUserByUserId()),
                commentEventEntity.getTimeStamp(),
                commentEventEntity.getText()
        );
    }

    public static ButtonEvent.PressTypes getPressType(short value) {
        for (ButtonEvent.PressTypes p : ButtonEvent.PressTypes.values()) {
            if (value == p.value()) return p;
        }
        return null;
    }
}
