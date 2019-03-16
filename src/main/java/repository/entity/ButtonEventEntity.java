package repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "ButtonEvent", schema = "main")
public class ButtonEventEntity {
    private Long id;
    private Short timeStamp;
    private Short pressType;
    private LectureEntity lectureByLectureId;
    private UserEntity userByUserId;

    public ButtonEventEntity(Long id, Short timeStamp, Short pressType, LectureEntity lectureByLectureId, UserEntity userByUserId) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.pressType = pressType;
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
    @Column(name = "PressType", nullable = true)
    public Short getPressType() {
        return pressType;
    }

    public void setPressType(Short pressType) {
        this.pressType = pressType;
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
