package mk.finki.ukim.mk.labbb.wp.model;

import lombok.Data;

import java.util.List;

@Data
public class BookStore {
    private Long id;
    private String name;
    private String city;
    private String address;
    List<Book> books;

    public BookStore(Long id, String name){
        this.id = id;
        this.name = name;
    }
    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
