package mk.finki.ukim.mk.labbb.wp.service.implementation;

import mk.finki.ukim.mk.labbb.wp.model.Book;
import mk.finki.ukim.mk.labbb.wp.model.BookStore;
import mk.finki.ukim.mk.labbb.wp.repository.BookStoreRepository;
import mk.finki.ukim.mk.labbb.wp.service.IBookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService implements IBookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }
    public BookStore findById(Long id) {
        return bookStoreRepository.findById(id).orElse(null);
    }
    public void addBookToStore(Book book, Long bookStoreId) {
        Optional<BookStore> optionalBookStore = bookStoreRepository.findById(bookStoreId);
        optionalBookStore.ifPresent(bookStore -> {
            bookStore.getBooks().add(book); // Assuming getBooks() returns the list of books in a BookStore
            book.setBookStore(bookStore); // Assuming setBookStore sets the BookStore for the Book
            bookStoreRepository.save(bookStore);
        });
    }



}
