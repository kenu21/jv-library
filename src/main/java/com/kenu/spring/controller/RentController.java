package com.kenu.spring.controller;

import com.kenu.spring.entity.Book;
import com.kenu.spring.entity.Rent;
import com.kenu.spring.entity.User;
import com.kenu.spring.service.interfaces.BookService;
import com.kenu.spring.service.interfaces.RentService;
import com.kenu.spring.service.interfaces.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/getbook")
    public String rentBook(@RequestParam("book_id") Long bookId, Model model, Principal principal) {
        Optional<User> optionalUser = userService.findByEmail(principal.getName());
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
    public String returnBook(@RequestParam("book_id") Long bookId, Principal principal) {
        Optional<User> optionalUser = userService.findByEmail(principal.getName());
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
    public String rentBooks(Model model, Principal principal) {
        Optional<User> optionalUser = userService.findByEmail(principal.getName());
        if (optionalUser.isEmpty()) {
            return "wrong";
        }
        User user = optionalUser.get();
        List<Book> booksRentByUser = rentService.getBooksRentByUser(user);
        model.addAttribute("rentBooks", booksRentByUser);
        return "rentInfo";
    }
}
