package repository.repoImplementation;

import domain.model.User;
import domain.repoInterfaces.UserRepo;
import mappers.ModelToHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.HibernateSessionFactory;
import repository.entity.UserEntity;
import repository.entity.UserRoleEntity;
import util.Tuple;

import java.util.Collection;

public class UserRepoImpl implements UserRepo {
    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    @Override
    public void addOrUpdate(User model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Tuple<UserEntity, Collection<UserRoleEntity>> pair = ModelToHibernate.getUserEntity(model);
        UserEntity userEntity = pair.getX();
        Collection<UserRoleEntity> roleEntities = pair.getY();
        session.saveOrUpdate(userEntity);

        for (UserRoleEntity role: roleEntities) {
            role.setUserEntity(userEntity);
            session.saveOrUpdate(role);
        }

        session.getTransaction().commit();
    }

    @Override
    public void delete(User model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        UserEntity userEntity = session.load(UserEntity.class, model.getID());
        userEntity.getUserRolesById().clear();
        session.delete(userEntity);

        session.getTransaction().commit();
    }

    @Override
    public void delete(short ID) {

    }

    @Override
    public User get(short ID) {
        return null;
    }
}
