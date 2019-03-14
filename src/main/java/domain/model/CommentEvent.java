package domain.model;

public class CommentEvent{
    private long ID;
    private long lectureID;
    private long userID;
    private int time; //minutes from beggining
    private String text;

    public CommentEvent(short ID, short lectureID, short userID, int time, String text) {
        this.ID = ID;
        this.lectureID = lectureID;
        this.userID = userID;
        this.time = time;
        this.text = text;
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

    public String getText() {
        return text;
    }
}
