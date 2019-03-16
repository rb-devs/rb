package domain.model;

import domain.Date;

public class Lecture{
    private long ID;
    private User teacher;
    private String name;
    private Date date;
    private String description;
    private short length;

    public Lecture(long ID, User teacher, String name, Date date, String description, short length) {
        this.ID = ID;
        this.teacher = teacher;
        this.name = name;
        this.date = date;
        this.description = description;
        this.length = length;
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
}
