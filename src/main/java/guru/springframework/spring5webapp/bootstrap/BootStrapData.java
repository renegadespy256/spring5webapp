package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author JKR = new Author("J.K.","Rowling");
        Book HP1= new Book("Harry Potter & The Soccer's Stone", "13: 9780747532743");

        JKR.getBooks().add(HP1);
        HP1.getAuthors().add(JKR);

        authorRepository.save(JKR);
        bookRepository.save(HP1);

        Author GGM = new Author("George","R.R.Martin");
        Book GOT = new Book("The Song of Ice & Fire","10 : 0007477155");

        GGM.getBooks().add(GOT);
        GOT.getAuthors().add(GGM);

        authorRepository.save(GGM);
        bookRepository.save(GOT);

        System.out.println("Started in bootstrap!");
        System.out.println("Number of books : "+bookRepository.count());





    }
}
