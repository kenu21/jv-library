package com.kenu.spring.service;

import com.kenu.spring.dao.interfaces.AuthorDao;
import com.kenu.spring.entity.Author;
import com.kenu.spring.service.interfaces.AuthorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> listAuthor() {
        return authorDao.listAuthor();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        return authorDao.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByNameAndSurname(String name, String surname) {
        return authorDao.findByNameAndSurname(name, surname);
    }
}
