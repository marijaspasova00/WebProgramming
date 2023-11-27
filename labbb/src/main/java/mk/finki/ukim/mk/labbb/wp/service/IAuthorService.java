package mk.finki.ukim.mk.labbb.wp.service;

import mk.finki.ukim.mk.labbb.wp.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> listAuthors();
    Author findById(Long id);
}
