package com.kenu.spring.service.interfaces;

import com.kenu.spring.entity.Book;
import com.kenu.spring.entity.Rent;
import com.kenu.spring.entity.User;

import java.util.List;

public interface RentService {
    void add(Rent rent);

    List<Rent> listRents();

    Rent rentBook(User user, Book book);

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
