package domain.model;

public class CommentEvent{
    private long ID;
    private Lecture lecture;
    private User user;
    private short time; //minutes from beggining
    private String text;

    public CommentEvent(long ID, Lecture lecture, User user, short time, String text) {
        this.ID = ID;
        this.lecture = lecture;
        this.user = user;
        this.time = time;
        this.text = text;
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

    public String getText() {
        return text;
    }
}
