package pl.rzaranek.spring6webapp.services;

import org.springframework.stereotype.Service;
import pl.rzaranek.spring6webapp.domain.Book;
import pl.rzaranek.spring6webapp.repositories.BookRepository;

/**
 * Created by robertZ on 2023-12-04.
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
