package repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Lecture", schema = "main")
public class LectureEntity {
    private Long id;
    private String name;
    private String date;
    private String description;
    private Short length;
    private Collection<ButtonEventEntity> buttonEventsById;
    private Collection<CommentEventEntity> commentEventsById;
    private UserEntity userByTeacherId;

    public LectureEntity(Long id, String name, String date, String description, Short length, UserEntity userByTeacherId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.length = length;
        this.userByTeacherId = userByTeacherId;
        this.buttonEventsById = new ArrayList<>();
        this.commentEventsById = new ArrayList<>();
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
    @Column(name = "Name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Date", nullable = true, length = -1)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Length", nullable = true)
    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    @OneToMany(mappedBy = "lectureByLectureId")
    public Collection<ButtonEventEntity> getButtonEventsById() {
        return buttonEventsById;
    }

    public void setButtonEventsById(Collection<ButtonEventEntity> buttonEventsById) {
        this.buttonEventsById = buttonEventsById;
    }

    @OneToMany(mappedBy = "lectureByLectureId")
    public Collection<CommentEventEntity> getCommentEventsById() {
        return commentEventsById;
    }

    public void setCommentEventsById(Collection<CommentEventEntity> commentEventsById) {
        this.commentEventsById = commentEventsById;
    }

    @ManyToOne
    @JoinColumn(name = "TeacherID", referencedColumnName = "ID")
    public UserEntity getUserByTeacherId() {
        return userByTeacherId;
    }

    public void setUserByTeacherId(UserEntity userByTeacherId) {
        this.userByTeacherId = userByTeacherId;
    }
}
