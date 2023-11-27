package mk.finki.ukim.mk.labbb.wp.service.implementation;

import mk.finki.ukim.mk.labbb.wp.model.Author;
import mk.finki.ukim.mk.labbb.wp.model.Book;
import mk.finki.ukim.mk.labbb.wp.repository.AuthorRepository;
import mk.finki.ukim.mk.labbb.wp.repository.BookRepository;
import mk.finki.ukim.mk.labbb.wp.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    List<Book> books;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        Author author = authorRepository.findById(authorId).orElse(null);
        Book book = bookRepository.findByIsbn(isbn).orElse(null);

        if (author != null && book != null) {
            book.getAuthors().add(author);
            return author;
        } else {
            return null;
        }
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElse(null);
    }
    public List<Book> findBooksByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();

        for (Book book : bookRepository.findAll()) {
            if (book.getAuthors().contains(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
    public List<Book> getAllBooks() {
        return bookRepository.getBooks();
    }
    public void add(Book book) {
        books.add(book);
    }
}
