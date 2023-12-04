package pl.rzaranek.spring6webapp.bootstap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.rzaranek.spring6webapp.domain.Author;
import pl.rzaranek.spring6webapp.domain.Book;
import pl.rzaranek.spring6webapp.domain.Publisher;
import pl.rzaranek.spring6webapp.repositories.AuthorRepository;
import pl.rzaranek.spring6webapp.repositories.BookRepository;
import pl.rzaranek.spring6webapp.repositories.PublisherRepository;

import java.util.Set;

/**
 * Created by robertZ on 2023-12-03.
 */
@Component
public class BootstapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author prus = new Author();
        prus.setFirstName("Bolesław");
        prus.setLastName("Prus");

        Book chlopi = new Book();
        chlopi.setTitle("Chłopi");
        chlopi.setIsbn("ISBN/1");

        Author sienkiewicz = new Author();
        sienkiewicz.setFirstName("Henryk");
        sienkiewicz.setLastName("Sienkiewicz");

        Book potop = new Book();
        potop.setTitle("Potop");
        potop.setIsbn("ISBN/2");

        Author prusSaved = authorRepository.save(prus);
        Author sienkiewiczSaved = authorRepository.save(sienkiewicz);
        Book chlopiSaved = bookRepository.save(chlopi);
        Book potopSaved = bookRepository.save(potop);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Znak");
        publisher.setAddress("Bracka 20");
        publisher.setCity("Cracow");
        publisher.setState("małopolska");
        publisher.setZip("30-303");

        Publisher publisherSaved = publisherRepository.save(publisher);

        chlopiSaved.setPublisher(publisherSaved);
        potopSaved.setPublisher(publisherSaved);

        prusSaved.getBooks().add(chlopiSaved);
        chlopiSaved.getAuthors().add(prusSaved);
        sienkiewiczSaved.getBooks().add(potopSaved);
        potopSaved.getAuthors().add(sienkiewiczSaved);

        bookRepository.save(chlopiSaved);
        bookRepository.save(potopSaved);
        authorRepository.save(prusSaved);
        authorRepository.save(sienkiewiczSaved);

        System.out.println("In Bootsrap");
        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Books count: " + bookRepository.count());

        bookRepository.findAll().forEach(book -> {
            Set<Author> authors = book.getAuthors();
            if (authors == null)
                System.out.println("No authors for book " + book.getTitle());
            else
                System.out.println("Authors count for book " + book.getTitle() + ": " + authors.size());
        });

        authorRepository.findAll().forEach(author -> {
            Set<Book> books = author.getBooks();
            if (books == null) {
                System.out.println("Author " + author.getLastName() + " have no books");
            }
            else {
                System.out.println("Author " + author.getLastName() + " have " + books.size() + " books");
            }
        });


        System.out.println("Publisher count: " + publisherRepository.count());

    }
}
