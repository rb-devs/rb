package domain.Model;

public class CommentEvent implements Model{
    private short ID;
    private short lectureID;
    private short userID;
    private int time; //minutes from beggining?
    private String text;

    public CommentEvent(short ID, short lectureID, short userID, int time, String text) {
        this.ID = ID;
        this.lectureID = lectureID;
        this.userID = userID;
        this.time = time;
        this.text = text;
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

    public String getText() {
        return text;
    }
}
