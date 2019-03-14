package domain.model;

public class ButtonEvent {
    enum PressTypes {
        RED,
        GREEN
    }

    private long ID;
    private long lectureID;
    private long userID;
    private int time; //minutes from beggining?
    private ButtonEvent.PressTypes pressType;

    public ButtonEvent(short ID, short lectureID, short userID, int time, ButtonEvent.PressTypes pressType) {
        this.ID = ID;
        this.lectureID = lectureID;
        this.userID = userID;
        this.time = time;
        this.pressType = pressType;
    }

    public long getID() {
        return ID;
    }

    public long getLectureID() {
        return lectureID;
    }

    public long getUserID() {
        return userID;
    }

    public int getTime() {
        return time;
    }

    public ButtonEvent.PressTypes pressType() {
        return pressType;
    }
}
