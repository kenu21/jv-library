package mate.academy.spring.dao.interfaces;

import java.util.List;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentDao {
    void add(Rent rent);

    List<Rent> listRents();

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
