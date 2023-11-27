package mk.finki.ukim.mk.labbb.web.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import mk.finki.ukim.mk.labbb.wp.service.implementation.BookService;

@WebServlet(name = "book-servlet", urlPatterns = "/listBooks")
public class BookServlet extends HttpServlet {

}
