package domain.RepoInterfaces;

import domain.Model.Model;

interface CRUDRepo<T extends Model> {
    void addModel(T model);

    void deleteModel(T model);

    void deleteModel(short ID);

    T getModel(short ID);

    void updateModel(T model);
}
