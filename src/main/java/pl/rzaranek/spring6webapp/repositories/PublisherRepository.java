package pl.rzaranek.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.rzaranek.spring6webapp.domain.Publisher;

/**
 * Created by robertZ on 2023-12-03.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
