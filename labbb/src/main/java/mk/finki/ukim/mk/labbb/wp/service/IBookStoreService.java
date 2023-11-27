package mk.finki.ukim.mk.labbb.wp.service;
import mk.finki.ukim.mk.labbb.wp.model.Book;
import mk.finki.ukim.mk.labbb.wp.model.BookStore;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookStoreService {
        List<BookStore> findAll();
        public void addBookToStore(Book book, Long bookStoreId);
}
