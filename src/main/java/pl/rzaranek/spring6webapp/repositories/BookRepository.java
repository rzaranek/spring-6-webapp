package pl.rzaranek.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.rzaranek.spring6webapp.domain.Book;

/**
 * Created by robertZ on 2023-12-03.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
