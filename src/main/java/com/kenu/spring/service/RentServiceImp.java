package com.kenu.spring.service;

import com.kenu.spring.dao.interfaces.RentDao;
import com.kenu.spring.entity.Book;
import com.kenu.spring.entity.Rent;
import com.kenu.spring.entity.User;
import com.kenu.spring.service.interfaces.RentService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImp implements RentService {

    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public void add(Rent rent) {
        rentDao.add(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> listRents() {
        return rentDao.listRents();
    }

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(LocalDate.now(), user, book);
        rentDao.add(rent);
        return rent;
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        rentDao.returnBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return rentDao.getBooksRentByUser(user);
    }
}
