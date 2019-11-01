package com.kenu.spring.dao.interfaces;

import com.kenu.spring.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void add(Book book);

    Optional<Book> get(Long id);

    List<Book> listBooks();

    List<Book> findByTitle(String title);
}
