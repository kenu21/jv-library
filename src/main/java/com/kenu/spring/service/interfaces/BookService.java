package com.kenu.spring.service.interfaces;

import com.kenu.spring.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void add(Book book);

    Optional<Book> get(Long id);

    List<Book> listBooks();

    List<Book> findByTitle(String title);
}
