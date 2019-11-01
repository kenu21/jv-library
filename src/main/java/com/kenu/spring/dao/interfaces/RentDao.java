package com.kenu.spring.dao.interfaces;

import com.kenu.spring.entity.Book;
import com.kenu.spring.entity.Rent;
import com.kenu.spring.entity.User;

import java.util.List;

public interface RentDao {
    void add(Rent rent);

    List<Rent> listRents();

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
