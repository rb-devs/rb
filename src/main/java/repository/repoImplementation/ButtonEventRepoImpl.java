package repository.repoImplementation;

import domain.model.ButtonEvent;
import domain.repoInterfaces.ButtonEventRepo;
import mappers.HibernateToModel;
import mappers.ModelToHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HibernateSessionFactory;
import repository.entity.ButtonEventEntity;

public class ButtonEventRepoImpl implements ButtonEventRepo {
    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    public ButtonEvent addOrUpdate(ButtonEvent model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        ButtonEventEntity buttonEventEntity = ModelToHibernate.getButtonEventEntity(model);
        session.saveOrUpdate(buttonEventEntity);

        session.getTransaction().commit();

        return HibernateToModel.getButtonEvent(buttonEventEntity);
    }

    @Override
    public void delete(ButtonEvent model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        ButtonEventEntity buttonEventEntity = session.load(ButtonEventEntity.class, model.getID());
        session.delete(buttonEventEntity);

        session.getTransaction().commit();
    }

    @Override
    public ButtonEvent add(ButtonEvent model) {
        return null;
    }

    @Override
    public void update(ButtonEvent model) {

    }
}
