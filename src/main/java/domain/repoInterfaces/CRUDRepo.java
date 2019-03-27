package domain.repoInterfaces;

import java.util.Collection;

interface CRUDRepo<T> {
    T addOrUpdate(T model);

    void delete(T model);
}
