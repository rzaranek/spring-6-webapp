package pl.rzaranek.spring6webapp.services;

import pl.rzaranek.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
