package mate.academy.spring.service.interfaces;

import java.util.List;

import mate.academy.spring.entity.Book;

public interface BookService {
    void add(Book book);

    List<Book> listBooks();

    List<Book> findByTitle(String title);
}
