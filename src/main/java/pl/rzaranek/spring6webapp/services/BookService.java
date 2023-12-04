package pl.rzaranek.spring6webapp.services;

import pl.rzaranek.spring6webapp.domain.Book;

/**
 * Created by robertZ on 2023-12-04.
 */

public interface BookService {
    Iterable<Book> findAll();
}
