package domain.Model;

import java.util.ArrayList;

public class User implements Model{
    private short ID;
    private String login;
    private String name;
    private short age;
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

    public short getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }
}
