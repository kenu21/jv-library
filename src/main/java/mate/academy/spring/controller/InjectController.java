package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.interfaces.BookService;
import mate.academy.spring.service.interfaces.RentService;
import mate.academy.spring.service.interfaces.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectController {

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
        LocalDate localDateBora = LocalDate.now();
        User bora = new User("Sunil", "Bora",
                "suni.bora@example.com");
        Rent rentBora = new Rent(localDateBora, bora, master);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        BookService bookService = context.getBean(BookService.class);
        RentService rentService = context.getBean(RentService.class);

        userService.add(bora);
        bookService.add(master);
        rentService.add(rentBora);

        Book zaraturstra = new Book("Tak govoril Zaratustra", new ArrayList<Author>(),1883, 200.3);
        Author nizshe = new Author("Fridrih", "Nizshe", new ArrayList<>());
        List<Book> booksZaratustra = new ArrayList<>();
        booksZaratustra.add(zaraturstra);
        List<Author> authorsNizshe = new ArrayList<>();
        authorsNizshe.add(nizshe);
        zaraturstra.setAuthors(Collections.singletonList(nizshe));
        nizshe.setBooks(booksZaratustra);
        LocalDate localDateMiller = LocalDate.now();
        User miller = new User("David", "Miller",
                "david.miller@example.com");
        Rent rentMiller = new Rent(localDateMiller, miller, zaraturstra);

        userService.add(miller);
        bookService.add(zaraturstra);
        rentService.add(rentMiller);

        Book zhizn = new Book("Tajnaja Zhizn", new ArrayList<Author>(),1990, 50.5);
        Author lavey = new Author("Anton", "LaVey", new ArrayList<>());
        List<Book> booksZhizn = new ArrayList<>();
        booksZhizn.add(zhizn);
        List<Author> authorsLavey = new ArrayList<>();
        authorsLavey.add(lavey);
        zhizn.setAuthors(Collections.singletonList(lavey));
        lavey.setBooks(booksZhizn);
        LocalDate localDateSingh = LocalDate.now();
        User singh = new User("Sameer", "Singh",
                "sameer.singh@example.com");
        Rent rentSingh = new Rent(localDateSingh, singh, zhizn);

        userService.add(singh);
        bookService.add(zhizn);
        rentService.add(rentSingh);

        return "forward:";
    }
}
