package domain.Model;

public class ButtonEvent implements Model {
    private static final boolean RED = false;
    private static final boolean GREEN = true;

    private short ID;
    private short lectureID;
    private short userID;
    private int time; //minutes from beggining?
    private boolean pressType;

    public ButtonEvent(short ID, short lectureID, short userID, int time, boolean pressType) {
        this.ID = ID;
        this.lectureID = lectureID;
        this.userID = userID;
        this.time = time;
        this.pressType = pressType;
    }

    public short getID() {
        return ID;
    }

    public short getLectureID() {
        return lectureID;
    }

    public short getUserID() {
        return userID;
    }

    public int getTime() {
        return time;
    }

    public boolean pressType() {
        return pressType;
    }
}
