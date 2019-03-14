package domain.model;

import domain.Date;

public class Lecture{
    private long ID;
    private long teacherID;
    private String name;
    private Date date;
    private String description;
    private int length; //minutes? 60, 90

    public Lecture(short ID, short teacherID, String name, Date date, String description, int length) { //may be builder?
        this.ID = ID;
        this.teacherID = teacherID;
        this.name = name;
        this.date = date;
        this.description = description;
        this.length = length;
    }

    public long getID() {
        return ID;
    }

    public long getTeacherID() {
        return teacherID;
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

    public int getLength() {
        return length;
    }
}
