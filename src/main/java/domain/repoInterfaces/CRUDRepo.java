package domain.repoInterfaces;

interface CRUDRepo<T> {
    void addOrUpdate(T model);

    void delete(T model);

    void delete(short ID);

    T get(short ID);
}
