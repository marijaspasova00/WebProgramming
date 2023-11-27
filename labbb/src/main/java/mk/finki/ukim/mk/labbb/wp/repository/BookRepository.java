package mk.finki.ukim.mk.labbb.wp.repository;

import mk.finki.ukim.mk.labbb.wp.model.Author;
import mk.finki.ukim.mk.labbb.wp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Repository
public class BookRepository {
    private final BookStoreRepository bookStoreRepository;

    List<Book> books;
    public BookRepository(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
        this.books = new ArrayList<>();
        initializeBooks();

    }
    private void initializeBooks() {
        Book book1 = (new Book("978-3-16-148410-0", "Therapy"));
        Book book2 = (new Book("978-3-16-148410-1", "It Ends with Us"));
        Book book3 = (new Book("978-3-16-148410-2", "You Can Heal Your Life"));
        Book book4 = (new Book("978-3-16-148410-3", "The Miracles of Your Mind"));
        Book book5 = (new Book("978-3-16-148410-4", "The Power of Now"));

        book1.setBookStore(bookStoreRepository.findAll().get(0));
        book2.setBookStore(bookStoreRepository.findAll().get(1));
        book3.setBookStore(bookStoreRepository.findAll().get(2));
        book4.setBookStore(bookStoreRepository.findAll().get(3));
        book5.setBookStore(bookStoreRepository.findAll().get(4));


        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

    }
    public List<Book> findAll(){
        return books;
    }
    public Optional<Book> findByIsbn(String isbn){
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }
    public Author addAuthorToBook(Author author, Book book) {
        Optional<Book> foundBook = findByIsbn(book.getIsbn());

        if (foundBook.isEmpty()) {
            System.out.println("This book does not exist!");
            return null;
        }
        Book bookToUpdate = foundBook.get();
        bookToUpdate.getAuthors().add(author);
        return author;
    }

    public List<Book> getBooks() {
        return books;
    }

}
