package repository.repoImplementation;

import domain.model.User;
import domain.repoInterfaces.UserRepo;
import mappers.HibernateToModel;
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
    public void delete(User model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        UserEntity userEntity = session.load(UserEntity.class, model.getID());
        userEntity.getUserRolesById().clear();
        session.delete(userEntity);

        session.getTransaction().commit();
    }

    @Override
    public User get(String username, String pass) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public User add(User model) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Tuple<UserEntity, Collection<UserRoleEntity>> pair = ModelToHibernate.getUserEntity(model);
        UserEntity userEntity = pair.getX();
        Collection<UserRoleEntity> roleEntities = pair.getY();
        long id = (long)session.save(userEntity);

        for (UserRoleEntity role: roleEntities) {
            role.setUserEntity(userEntity);
            session.save(role);
        }
        session.getTransaction().commit();

        userEntity.setUserRolesById(roleEntities);

        return HibernateToModel.getUser(userEntity);
    }

    @Override
    public void update(User model) {
    }
}
