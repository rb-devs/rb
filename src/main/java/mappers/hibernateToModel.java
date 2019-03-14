package mappers;

import domain.model.Role;
import domain.model.User;
import repository.RoleEntity;
import repository.UserEntity;
import repository.UserRoleEntity;

import java.util.ArrayList;
import java.util.Collection;

public class hibernateToModel {
    public static User getUser(UserEntity userEntity) {
        Collection<Role> roles = new ArrayList<Role>();
        for (UserRoleEntity userRole : userEntity.getUserRolesById()) {
            roles.add(new Role(userRole.getRoleByRoleId().getName(), userRole.getRating()));
        }
        return new User(userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getName(),
                userEntity.getAge(),
                roles
        );
    }
}
