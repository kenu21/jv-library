package mate.academy.spring.controller;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(ModelMap model) {
        model.put("allBooks", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/{id}")
    public String bookInfo(ModelMap model, @PathVariable("id") Long id) {
        Optional<Book> optionalBook = bookService.get(id);
        if (optionalBook.isEmpty()) {
            return "wrong";
        }
        model.put("infoBook", optionalBook.get());
        return "bookInfo";
    }

    @GetMapping("/find")
    public String findByTitle(@RequestParam("title") String title, Model model) {
        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("allBooks", books);
        return "allBooks";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book, ModelMap model) {
        bookService.add(book);
        return getAllBooks(model);
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "book/create";
    }
}
