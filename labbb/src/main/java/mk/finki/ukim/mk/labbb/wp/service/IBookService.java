package mk.finki.ukim.mk.labbb.wp.service;

import mk.finki.ukim.mk.labbb.wp.model.Author;
import mk.finki.ukim.mk.labbb.wp.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
}
