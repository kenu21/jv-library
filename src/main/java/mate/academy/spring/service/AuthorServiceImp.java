package mate.academy.spring.service;

import java.util.List;

import mate.academy.spring.dao.interfaces.AuthorDao;
import mate.academy.spring.entity.Author;
import mate.academy.spring.service.interfaces.AuthorService;
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
