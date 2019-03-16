package domain.model;

import java.util.ArrayList;
import java.util.Collection;

public class User{
    private long ID;
    private String login;
    private String name;
    private String password;
    private short age;
    private Collection<Role> roles;

    public User(long ID, String login, String name, String password, short age, Collection<Role> roles) {
        this.ID = ID;
        this.login = login;
        this.name = name;
        this.password = password;
        this.age = age;
        this.roles = roles;
    }

    public Collection<Role> getRoles() {
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

    public short getAge() {
        return age;
    }

    public String getPassword(){return password;}
}
