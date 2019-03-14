package domain.repoInterfaces;

interface CRUDRepo<T> {
    void add(T model);

    void delete(T model);

    void delete(short ID);

    T get(short ID);

    void update(T model);
}
