package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Author JKR = new Author("J.K.","Rowling");
        Book HP1= new Book("Harry Potter & The Soccer's Stone", "13: 9780747532743");

        HP1.addAuthors(JKR);

        Author GGM = new Author("George","R.R.Martin");
        Book GOT = new Book("The Song of Ice & Fire","10 : 0007477155");

        GOT.addAuthors(GGM);

        System.out.println("Started in bootstrap!");

        Publisher pb = new Publisher("Cristiano Messi", "Madrid, Spain");

        HP1.setPublisher(pb);

        GOT.setPublisher(pb);

        publisherRepository.save(pb);
        authorRepository.save(GGM);
        bookRepository.save(GOT);
        authorRepository.save(JKR);
        bookRepository.save(HP1);
        System.out.println("Number of books : "+bookRepository.count());

        System.out.println("Number of Publishers : "+publisherRepository.count());






    }
}
