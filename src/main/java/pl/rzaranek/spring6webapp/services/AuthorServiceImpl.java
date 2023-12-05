package pl.rzaranek.spring6webapp.services;

import org.springframework.stereotype.Service;
import pl.rzaranek.spring6webapp.domain.Author;
import pl.rzaranek.spring6webapp.repositories.AuthorRepository;

/**
 * Created by robertZ on 2023-12-05.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
