package repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "Role", schema = "main")
public class RoleEntity {
    public static long USER = 1;
    public static long TEACHER = 2;
    public static long ADMIN = 3;

    private Long id;
    private String name;

    public RoleEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "ID", nullable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
