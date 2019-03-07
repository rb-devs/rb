package domain.Model;

import domain.Date;

public class Lecture implements Model{
    private short ID;
    private short teacherID;
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

    public short getID() {
        return ID;
    }

    public short getTeacherID() {
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
