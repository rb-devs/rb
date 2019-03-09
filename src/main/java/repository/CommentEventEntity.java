package repository;

import javax.persistence.*;

@Entity
@Table(name = "CommentEvent", schema = "main")
public class CommentEventEntity {
    private Short id;
    private Short timeStamp;
    private String text;
    private LectureEntity lectureByLectureId;
    private UserEntity userByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = true)
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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
