package repository;

import javax.persistence.*;

@Entity
@Table(name = "UserRole", schema = "main")
public class UserRoleEntity {
    private Short rating;
    private UserEntity userByUserId;
    private RoleEntity roleByRoleId;

    @Id
    @Column(name = "Rating", nullable = true)
    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "RoleID", referencedColumnName = "ID")
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
