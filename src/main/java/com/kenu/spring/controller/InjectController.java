package com.kenu.spring.controller;

import com.kenu.spring.entity.Author;
import com.kenu.spring.entity.Book;
import com.kenu.spring.entity.Role;
import com.kenu.spring.entity.User;
import com.kenu.spring.service.interfaces.BookService;
import com.kenu.spring.service.interfaces.RoleService;
import com.kenu.spring.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String injectData() {
        Book master = new Book("Master and Margarita", new ArrayList<Author>(), 1966, 666.6);
        Author bulgakov = new Author("Mihail", "Bulgakov", new ArrayList<>());
        List<Book> booksMaster = new ArrayList<>();
        booksMaster.add(master);
        List<Author> authorsBulgakov = new ArrayList<>();
        authorsBulgakov.add(bulgakov);
        master.setAuthors(Collections.singletonList(bulgakov));
        bulgakov.setBooks(booksMaster);

        bookService.add(master);

        Book zaraturstra = new Book("Tak govoril Zaratustra", new ArrayList<Author>(),1883, 200.3);
        Author nizshe = new Author("Fridrih", "Nizshe", new ArrayList<>());
        List<Book> booksZaratustra = new ArrayList<>();
        booksZaratustra.add(zaraturstra);
        List<Author> authorsNizshe = new ArrayList<>();
        authorsNizshe.add(nizshe);
        zaraturstra.setAuthors(Collections.singletonList(nizshe));
        nizshe.setBooks(booksZaratustra);

        bookService.add(zaraturstra);

        Book zhizn = new Book("Tajnaja Zhizn", new ArrayList<Author>(),1990, 50.5);
        Author lavey = new Author("Anton", "LaVey", new ArrayList<>());
        List<Book> booksZhizn = new ArrayList<>();
        booksZhizn.add(zhizn);
        List<Author> authorsLavey = new ArrayList<>();
        authorsLavey.add(lavey);
        zhizn.setAuthors(Collections.singletonList(lavey));
        lavey.setBooks(booksZhizn);

        bookService.add(zhizn);

        return "forward:";
    }

    @PostConstruct
    public void injectRoleUser() {
        Role userRole = new Role("ROLE_USER");
        roleService.add(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
        roleService.add(adminRole);

        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        roles.add(adminRole);
        User admin = new User("admin", "admin", "name", "surname", "bla@bla.bla");
        admin.setRoles(roles);
        userService.add(admin);
    }
}
