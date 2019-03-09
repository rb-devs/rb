package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainTest {
    public static void main(String[] args) {
        // create new hibernate factory and select session
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        UserEntity user = new UserEntity("test3", "test", "test", 1);
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        HibernateSessionFactory.shutdown();
    }


}
