package mk.finki.ukim.mk.labbb.wp.repository;

import mk.finki.ukim.mk.labbb.wp.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class AuthorRepository {
    private List<Author> authors;
    public AuthorRepository() {
        this.authors = new ArrayList<>();
        initializeAuthors();
    }

    private void initializeAuthors() {
        authors.add(new Author(1L,"Sebastian", "Fitzek"));
        authors.add(new Author(2L,"Colleen", "Hoover"));
        authors.add(new Author(3L,"Louise", "Hay"));
        authors.add(new Author(4L,"Joseph", "Murphy"));
        authors.add(new Author(5L,"Eckhart", "Tolle"));
    }
    public List<Author> findAll(){
        return authors;
    }
    public Optional<Author> findById(Long id){
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst();
    }
}
