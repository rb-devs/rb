package repository.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "User", schema = "main")
public class UserEntity {
    private Long id;
    private String login;
    private String password;
    private String name;
    private Short age;
    private Collection<ButtonEventEntity> buttonEventsById;
    private Collection<CommentEventEntity> commentEventsById;
    private Collection<LectureEntity> lecturesById;
    private Collection<UserRoleEntity> userRolesById;

    public UserEntity(){}

    public UserEntity(Long id, String login, String password, String name, Short age) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public UserEntity(String login, String password, String name, Short age) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Login", nullable = true, length = -1)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Age", nullable = true)
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<ButtonEventEntity> getButtonEventsById() {
        return buttonEventsById;
    }

    public void setButtonEventsById(Collection<ButtonEventEntity> buttonEventsById) {
        this.buttonEventsById = buttonEventsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CommentEventEntity> getCommentEventsById() {
        return commentEventsById;
    }

    public void setCommentEventsById(Collection<CommentEventEntity> commentEventsById) {
        this.commentEventsById = commentEventsById;
    }

    @OneToMany(mappedBy = "userByTeacherId")
    public Collection<LectureEntity> getLecturesById() {
        return lecturesById;
    }

    public void setLecturesById(Collection<LectureEntity> lecturesById) {
        this.lecturesById = lecturesById;
    }

    @OneToMany(mappedBy = "pk.userEntity", orphanRemoval = true)
    public Collection<UserRoleEntity> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRoleEntity> userRolesById) {
        this.userRolesById = userRolesById;
    }
}
