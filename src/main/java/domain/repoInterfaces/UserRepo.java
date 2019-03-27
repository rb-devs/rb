package domain.repoInterfaces;

import domain.model.User;

import java.util.Collection;

public interface UserRepo extends CRUDRepo<User> {
    User get(String username);

    Collection<User> getAll();
}
