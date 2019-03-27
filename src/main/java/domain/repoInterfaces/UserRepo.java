package domain.repoInterfaces;

import domain.model.User;

public interface UserRepo extends CRUDRepo<User> {
    User get(String username);
}
