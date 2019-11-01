package com.kenu.spring.dao.interfaces;

import com.kenu.spring.entity.Author;

import java.util.List;

public interface AuthorDao {
    void add(Author author);

    List<Author> listAuthor();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
