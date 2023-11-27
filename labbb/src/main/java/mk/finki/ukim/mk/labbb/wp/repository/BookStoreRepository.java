package mk.finki.ukim.mk.labbb.wp.repository;

import mk.finki.ukim.mk.labbb.wp.model.Book;
import mk.finki.ukim.mk.labbb.wp.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class BookStoreRepository {
    private List<BookStore> bookStores;
    private final BookRepository books;

    public BookStoreRepository(BookRepository books) {
        this.books = books;
        bookStores = new ArrayList<>();
        initializeBookStores();
    }

    private void initializeBookStores() {

        BookStore store1 = new BookStore(20L,"Literatura.mk");
        BookStore store2 = new BookStore(25L, "Tri");
        BookStore store3 = new BookStore(30L,"Kesh");
        BookStore store4 = new BookStore(35L,"Kultura");
        BookStore store5 = new BookStore(40L,"Prosvetno delo");

        bookStores.add(store1);
        bookStores.add(store2);
        bookStores.add(store3);
        bookStores.add(store4);
        bookStores.add(store5);
    }

    public List<BookStore> findAll() {
        return bookStores;
    }

    public Optional<BookStore> findById(Long id) {
        return bookStores.stream()
                .filter(store -> store.getId().equals(id))
                .findFirst();
    }
}
