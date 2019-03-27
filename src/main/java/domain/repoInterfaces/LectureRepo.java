package domain.repoInterfaces;

import domain.model.Lecture;

import java.util.Collection;

public interface LectureRepo extends CRUDRepo<Lecture> {
    Collection<Lecture> getAll();
}
