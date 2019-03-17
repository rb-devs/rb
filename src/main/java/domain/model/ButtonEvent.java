package domain.model;

public class ButtonEvent {
    public enum PressTypes {
        RED ((short)0),
        GREEN ((short)1);

        private final short value;

        PressTypes(short value) {
            this.value = value;
        }

        public short value() {
            return value;
        }
    }

    private long ID;
    private Lecture lecture;
    private User user;
    private short time; //minutes from beggining?
    private ButtonEvent.PressTypes pressType;

    public ButtonEvent(long ID, Lecture lecture, User user, short time, PressTypes pressType) {
        this.ID = ID;
        this.lecture = lecture;
        this.user = user;
        this.time = time;
        this.pressType = pressType;
    }

    public long getID() {
        return ID;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public User getUser() {
        return user;
    }

    public short getTime() {
        return time;
    }

    public ButtonEvent.PressTypes pressType() {
        return pressType;
    }
}
