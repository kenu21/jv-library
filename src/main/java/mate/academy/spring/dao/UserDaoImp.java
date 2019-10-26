package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import mate.academy.spring.dao.interfaces.UserDao;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(User.class, id));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE username=:username", User.class);
        query.setParameter("username", username);
        try {
            User user = query.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE email=:email", User.class);
        query.setParameter("email", email);
        try {
            User user = query.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User", User.class);
        return query.getResultList();
    }
}
