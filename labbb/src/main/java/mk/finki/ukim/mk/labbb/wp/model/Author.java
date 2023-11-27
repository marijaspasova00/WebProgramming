package mk.finki.ukim.mk.labbb.wp.model;

import lombok.Data;

@Data
public class Author {
    Long id;
    String name;
    String surname;
    String biography;
    public Author(Long id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    // Setters and getters for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Setters and getters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Setters and getters for surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Setters and getters for biography
    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
