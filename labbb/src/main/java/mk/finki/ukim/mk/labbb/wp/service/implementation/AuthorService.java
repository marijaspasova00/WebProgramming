package mk.finki.ukim.mk.labbb.wp.service.implementation;

import mk.finki.ukim.mk.labbb.wp.model.Author;
import mk.finki.ukim.mk.labbb.wp.repository.AuthorRepository;
import mk.finki.ukim.mk.labbb.wp.service.IAuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}
