package repository.repoImplementation;

import domain.model.CommentEvent;
import domain.repoInterfaces.CommentEventRepo;
import mappers.ModelToHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HibernateSessionFactory;
import repository.entity.CommentEventEntity;

public class CommentEventRepoImpl implements CommentEventRepo {

    private Session session;

    public CommentEventRepoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    @Override
    public void addOrUpdate(CommentEvent model) {
        session.beginTransaction();

        CommentEventEntity commentEventEntity = ModelToHibernate.getCommentEventEntity(model);
        session.saveOrUpdate(commentEventEntity);

        session.getTransaction().commit();
    }

    @Override
    public void delete(CommentEvent model) {
        session.beginTransaction();

        CommentEventEntity commentEventEntity = session.load(CommentEventEntity.class, model.getID());
        session.delete(commentEventEntity);

        session.getTransaction().commit();
    }

    @Override
    public void delete(short ID) {

    }

    @Override
    public CommentEvent get(short ID) {
        return null;
    }
}
