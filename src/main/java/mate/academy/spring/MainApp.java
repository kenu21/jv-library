package mate.academy.spring;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.interfaces.AuthorService;
import mate.academy.spring.service.interfaces.BookService;
import mate.academy.spring.service.interfaces.RentService;
import mate.academy.spring.service.interfaces.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) throws SQLException {
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

        List<User> usersFromDb = userService.listUsers();
        for (User user : usersFromDb) {
            System.out.println("Id = " + user.getId());
            System.out.println("Name = " + user.getName());
            System.out.println("Surname = " + user.getSurname());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<Book> booksFromDb = bookService.listBooks();
        for (Book book : booksFromDb) {
            System.out.println("Id = " + book.getId());
            System.out.println("Title = " + book.getTitle());
            System.out.println("Authors = " + book.getAuthors());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        AuthorService authorService = context.getBean(AuthorService.class);

        List<Author> authorsFromDb = authorService.listAuthor();
        for (Author author : authorsFromDb) {
            System.out.println("Id = " + author.getId());
            System.out.println("Name = " + author.getName());
            System.out.println("Surname = " + author.getSurname());
            System.out.println("Books = " + author.getBooks());
            System.out.println();
        }

        List<Rent> rentFromDb = rentService.listRents();
        for (Rent rent : rentFromDb) {
            System.out.println("Id = " + rent.getId());
            System.out.println("RentDate = " + rent.getRentDate());
            System.out.println("User = " + rent.getUser());
            System.out.println("Book = " + rent.getBook());
            System.out.println();
        }

        System.out.println(bookService.findByTitle("Master and Margarita"));
        System.out.println();
        System.out.println(authorService.findByName("Fridrih"));
        System.out.println();
        System.out.println(authorService.findByNameAndSurname("Anton", "Lavey"));

        context.close();
    }
}
