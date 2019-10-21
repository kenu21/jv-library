package mate.academy.spring.controller;

import java.util.NoSuchElementException;

import mate.academy.spring.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/info")
    public String bookInfo(ModelMap model, @RequestParam Long id) {
        model.put("infoBook", bookService.get(id).orElseThrow(NoSuchElementException::new));
        return "bookInfo";
    }
}
