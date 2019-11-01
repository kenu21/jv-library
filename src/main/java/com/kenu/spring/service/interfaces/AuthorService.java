package com.kenu.spring.service.interfaces;

import com.kenu.spring.entity.Author;

import java.util.List;

public interface AuthorService {
    void add(Author author);

    List<Author> listAuthor();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
