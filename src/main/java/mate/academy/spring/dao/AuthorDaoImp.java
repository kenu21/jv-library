package mate.academy.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import mate.academy.spring.dao.interfaces.AuthorDao;
import mate.academy.spring.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImp implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public List<Author> listAuthor() {
        @SuppressWarnings("unchecked")
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("from Author");
        return query.getResultList();
    }

    @Override
    public List<Author> findByName(String name) {
        @SuppressWarnings("unchecked")
        TypedQuery<Author> query =
                sessionFactory.getCurrentSession().createQuery("from Author where name=:name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        @SuppressWarnings("unchecked")
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("from Author where name=:name and surname=:surname");
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList();
    }
}
