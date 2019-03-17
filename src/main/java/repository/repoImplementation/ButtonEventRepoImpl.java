package repository.repoImplementation;

import domain.model.ButtonEvent;
import domain.repoInterfaces.ButtonEventRepo;
import mappers.ModelToHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HibernateSessionFactory;
import repository.entity.ButtonEventEntity;

public class ButtonEventRepoImpl implements ButtonEventRepo {

    private Session session;

    public ButtonEventRepoImpl(){
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    @Override
    public void addOrUpdate(ButtonEvent model) {
        session.beginTransaction();

        ButtonEventEntity buttonEventEntity = ModelToHibernate.getButtonEventEntity(model);
        session.saveOrUpdate(buttonEventEntity);

        session.getTransaction().commit();
    }

    @Override
    public void delete(ButtonEvent model) {
        session.beginTransaction();

        ButtonEventEntity buttonEventEntity = session.load(ButtonEventEntity.class, model.getID());
        session.delete(buttonEventEntity);
        
        session.getTransaction().commit();
    }

    @Override
    public void delete(short ID) {

    }

    @Override
    public ButtonEvent get(short ID) {
        return null;
    }
}
