package com.kenu.spring.dao;

import com.kenu.spring.dao.interfaces.BookDao;
import com.kenu.spring.entity.Book;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImp implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Book.class, id));
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query =
                sessionFactory.getCurrentSession().createQuery(
                        "FROM Book WHERE title LIKE CONCAT('%', :title, '%')", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
}
