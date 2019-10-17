package mate.academy.spring;

import java.sql.SQLException;
import java.util.List;

import mate.academy.spring.config.AppConfig;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        BookService bookService = context.getBean(BookService.class);

        // Add Books
        bookService.add(new Book("Master and Margarita", 1966, 666.6));
        bookService.add(new Book("Tak govoril Zaratustra", 1883, 200.3));
        bookService.add(new Book("Tajnaja Zhizn", 1990, 50.5));
        bookService.add(new Book("Faust", 1808, 150.6));

        // Get Books
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println("Id = " + book.getId());
            System.out.println("Name = " + book.getName());
            System.out.println("Year Name = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        context.close();
    }
}
