package com.kenu.spring.dao;

import com.kenu.spring.dao.interfaces.RentDao;
import com.kenu.spring.entity.Book;
import com.kenu.spring.entity.Rent;
import com.kenu.spring.entity.User;

import java.util.List;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImp implements RentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
    }

    @Override
    public List<Rent> listRents() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Rent", Rent.class);
        return query.getResultList();
    }

    @Override
    public void returnBook(User user, Book book) {
        Query<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Rent rent SET active = false"
                + " WHERE user_id=:userId AND book_id=:bookId");
        query.setParameter("userId", user.getId());
        query.setParameter("bookId", book.getId());
        query.executeUpdate();
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        Query<Book> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT rent.book FROM Rent rent"
                + " WHERE user_id=:userId AND active = true", Book.class);
        query.setParameter("userId", user.getId());
        return query.getResultList();
    }
}
