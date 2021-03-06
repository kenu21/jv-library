package com.kenu.spring.dao;

import com.kenu.spring.dao.interfaces.AuthorDao;
import com.kenu.spring.entity.Author;
import java.util.List;
import javax.persistence.TypedQuery;
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
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Author", Author.class);
        return query.getResultList();
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Author WHERE name LIKE CONCAT('%',:name,'%')", Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Author WHERE name LIKE CONCAT('%',:name,'%')"
                        + " AND surname LIKE CONCAT('%', :surname,'%')", Author.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList();
    }
}
