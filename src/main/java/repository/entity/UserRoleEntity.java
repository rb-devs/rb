package repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserRole", schema = "main")
@AssociationOverrides({
        @AssociationOverride(name = "pk.userEntity",
                joinColumns = @JoinColumn(name = "UserID")),
        @AssociationOverride(name = "pk.roleEntity",
                joinColumns = @JoinColumn(name = "RoleID"))
})
public class UserRoleEntity {
    private UserRoleID pk = new UserRoleID();
    private Short rating;

    public UserRoleEntity(UserEntity user, RoleEntity role, short rating) {
        setUserEntity(user);
        setRoleEntity(role);
        this.rating = rating;
    }

    @EmbeddedId
    public UserRoleID getPk() {
        return pk;
    }

    public void setPk(UserRoleID pk) {
        this.pk = pk;
    }

    @Transient
    public UserEntity getUserEntity() {
        return getPk().getUserEntity();
    }

    public void setUserEntity(UserEntity userEntity) {
        getPk().setUserEntity(userEntity);
    }

    @Transient
    public RoleEntity getRoleEntity() {
        return getPk().getRoleEntity();
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        getPk().setRoleEntity(roleEntity);
    }

    @Column(name = "Rating", nullable = true)
    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }
}
