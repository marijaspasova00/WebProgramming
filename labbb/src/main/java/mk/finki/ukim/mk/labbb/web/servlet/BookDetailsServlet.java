package mk.finki.ukim.mk.labbb.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.labbb.wp.model.Author;
import mk.finki.ukim.mk.labbb.wp.model.Book;
import mk.finki.ukim.mk.labbb.wp.service.implementation.AuthorService;
import mk.finki.ukim.mk.labbb.wp.service.implementation.BookService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "book-details-servlet", urlPatterns = "/bookDetails")
public class BookDetailsServlet extends HttpServlet {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookDetailsServlet(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String authorIdParam = req.getParameter("authorId");
        if (authorIdParam != null && !authorIdParam.isEmpty()) {
            Long authorId = Long.parseLong(authorIdParam);
            Author author = authorService.findById(authorId);

            if (author != null) {
                System.out.println("<html><body>");
                System.out.println("<h2>Details for Books by " + author.getName() + "</h2>");

                List<Book> booksByAuthor = bookService.findBooksByAuthor(author);

                for (Book book : booksByAuthor) {
                    System.out.println("<p>Title: " + book.getTitle() + "</p>");
                    System.out.println("<p>Genre: " + book.getGenre() + "</p>");
                    System.out.println("<p>Year: " + book.getYear() + "</p>");
                    System.out.println("<p>Authors: " + book.getAuthors() + "</p>");
                    System.out.println("<hr>");
                }

                System.out.println("</body></html>");
            } else {
                System.out.println("Author not found");
            }
        } else {
            System.out.println("Author ID parameter is missing");
        }
    }
}
