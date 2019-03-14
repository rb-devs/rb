package domain.model;

import java.util.ArrayList;

public class User{
    private long ID;
    private String login;
    private String name;
    private int age;
    private ArrayList<Role> roles;

    public User(short ID, String login, String name, short age, ArrayList<Role> roles) {
        this.ID = ID;
        this.login = login;
        this.name = name;
        this.age = age;
        this.roles = roles;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public long getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
