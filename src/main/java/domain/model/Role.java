package domain.model;

public class Role {
    private String name;
    private short rating;

    public Role(String name, short rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public short getRating() {
        return rating;
    }
}
