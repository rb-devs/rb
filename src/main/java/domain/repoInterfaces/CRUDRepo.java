package domain.repoInterfaces;

interface CRUDRepo<T> {
    void addOrUpdate(T model);

    void delete(T model);

    void delete(long ID);

    T get(long ID);
}
