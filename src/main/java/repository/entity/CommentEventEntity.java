package repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "CommentEvent", schema = "main")
public class CommentEventEntity {
    private Long id;
    private Short timeStamp;
    private String text;
    private LectureEntity lectureByLectureId;
    private UserEntity userByUserId;

    public CommentEventEntity(Long id, Short timeStamp, String text, LectureEntity lectureByLectureId, UserEntity userByUserId) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.text = text;
        this.lectureByLectureId = lectureByLectureId;
        this.userByUserId = userByUserId;
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
    @Column(name = "TimeStamp", nullable = true)
    public Short getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Short timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Basic
    @Column(name = "Text", nullable = true, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "LectureID", referencedColumnName = "ID")
    public LectureEntity getLectureByLectureId() {
        return lectureByLectureId;
    }

    public void setLectureByLectureId(LectureEntity lectureByLectureId) {
        this.lectureByLectureId = lectureByLectureId;
    }

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
