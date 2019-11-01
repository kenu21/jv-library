package com.kenu.spring.service;

import com.kenu.spring.dao.interfaces.BookDao;
import com.kenu.spring.entity.Book;
import com.kenu.spring.service.interfaces.BookService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> get(Long id) {
        return bookDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }
}
