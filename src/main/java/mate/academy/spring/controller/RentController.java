package mate.academy.spring.controller;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.interfaces.BookService;
import mate.academy.spring.service.interfaces.RentService;
import mate.academy.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    public static final Long USER_ID = 1L;

    @Autowired
    private RentService rentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/getbook")
    public String rentBook(@RequestParam("book_id") Long bookId, Model model) {
        Optional<User> optionalUser = userService.get(USER_ID);
        if (optionalUser.isEmpty()) {
            return "wrong";
        }
        User user = optionalUser.get();
        Optional<Book> optionalBook = bookService.get(bookId);
        if (optionalBook.isEmpty()) {
            return "wrong";
        }
        Book book = optionalBook.get();
        Rent rent = rentService.rentBook(user, book);
        model.addAttribute("rent", rent);
        return "forward:/book";
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("book_id") Long bookId) {
        Optional<User> optionalUser = userService.get(USER_ID);
        if (optionalUser.isEmpty()) {
            return "wrong";
        }
        User user = optionalUser.get();
        Optional<Book> optionalBook = bookService.get(bookId);
        if (optionalBook.isEmpty()) {
            return "wrong";
        }
        Book book = optionalBook.get();
        rentService.returnBook(user, book);
        return "forward:/book";
    }

    @GetMapping("/rent")
    public String rentBooks(Model model) {
        Optional<User> optionalUser = userService.get(USER_ID);
        if (optionalUser.isEmpty()) {
            return "wrong";
        }
        User user = optionalUser.get();
        List<Book> booksRentByUser = rentService.getBooksRentByUser(user);
        model.addAttribute("rentBooks", booksRentByUser);
        return "rentinfo";
    }
}