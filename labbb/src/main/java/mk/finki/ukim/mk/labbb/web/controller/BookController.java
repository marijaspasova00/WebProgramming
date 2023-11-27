package mk.finki.ukim.mk.labbb.web.controller;

//import ch.qos.logback.core.model.Model;
import mk.finki.ukim.mk.labbb.wp.model.Book;
import mk.finki.ukim.mk.labbb.wp.model.BookStore;
import mk.finki.ukim.mk.labbb.wp.service.implementation.BookService;
import mk.finki.ukim.mk.labbb.wp.service.implementation.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/books")
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        List<Book> books = bookService.getAllBooks();
        List<BookStore> bookStores = bookStoreService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bookStores", bookStores);
        model.addAttribute("error", error);
        return "listBooks";
    }

    @PostMapping("/books/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long bookStoreId) {
        BookStore selectedBookStore = bookStoreService.findById(bookStoreId);

        // Create a new book
        Book newBook = new Book(isbn, title);
        newBook.setGenre(genre);
        newBook.setYear(year);

        // Add the new book to the selected bookstore
        bookStoreService.addBookToStore(newBook, bookStoreId);

        return "redirect:/books";
    }
}
