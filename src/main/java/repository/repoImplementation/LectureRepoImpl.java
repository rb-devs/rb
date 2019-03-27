package repository.repoImplementation;

import domain.model.Lecture;
import domain.repoInterfaces.LectureRepo;
import mappers.HibernateToModel;
import mappers.ModelToHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HibernateSessionFactory;
import repository.entity.LectureEntity;

import java.util.Collection;

public class LectureRepoImpl implements LectureRepo {
    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public Lecture addOrUpdate(Lecture model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        LectureEntity lectureEntity = ModelToHibernate.getLectureEntity(model);
        session.saveOrUpdate(model);

        session.getTransaction().commit();

        return HibernateToModel.getLecture(lectureEntity);
    }

    @Override
    public void delete(Lecture model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        LectureEntity lectureEntity = session.load(LectureEntity.class, model.getID());
        lectureEntity.getButtonEventsById().clear();
        lectureEntity.getCommentEventsById().clear();
        session.delete(lectureEntity);

        session.getTransaction().commit();
    }

    @Override
    public Collection<Lecture> getAll() {
        return null;
    }


}
