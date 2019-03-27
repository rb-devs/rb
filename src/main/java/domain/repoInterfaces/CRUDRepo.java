package domain.repoInterfaces;

import java.util.Collection;

interface CRUDRepo<T> {
    T add(T model);

    void update(T model);

    void delete(T model);
}
