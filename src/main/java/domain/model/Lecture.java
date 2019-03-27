package domain.model;

import domain.Date;

import java.util.Collection;

public class Lecture{
    private long ID;
    private User teacher;
    private String name;
    private Date date;
    private String description;
    private short length;
    private Collection<ButtonEvent> buttonEvents;
    private Collection<CommentEvent> commentEvents;

    public Lecture(long ID, User teacher, String name, Date date, String description, short length, Collection<ButtonEvent> buttonEvents, Collection<CommentEvent> commentEvents) {
        this.ID = ID;
        this.teacher = teacher;
        this.name = name;
        this.date = date;
        this.description = description;
        this.length = length;
        this.buttonEvents = buttonEvents;
        this.commentEvents = commentEvents;
    }

    public long getID() {
        return ID;
    }

    public User getTeacher() {
        return teacher;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public short getLength() {
        return length;
    }

    public Collection<ButtonEvent> getButtonEvents() {
        return buttonEvents;
    }

    public Collection<CommentEvent> getCommentEvents() {
        return commentEvents;
    }
}
