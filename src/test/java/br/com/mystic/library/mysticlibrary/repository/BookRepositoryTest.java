package br.com.mystic.library.mysticlibrary.repository;

import static org.junit.jupiter.api.Assertions.*;

import br.com.mystic.library.mysticlibrary.model.Author;
import br.com.mystic.library.mysticlibrary.model.Book;
import br.com.mystic.library.mysticlibrary.model.Publishing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveAndFindBook() {
        Book book = new Book();
        book.setTitle("Test Book");

        Author author = new Author();
        author.setName("Test Author");
        List<Author> authors = List.of(author);

        Publishing publishing = new Publishing();
        publishing.setName("Test Publishing");

        book.setAuthors(authors);
        book.setPublishing(publishing);

        bookRepository.save(book);

        List<Book> books = bookRepository.findAll();
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
        assertEquals(1, books.get(0).getAuthors().size());
        assertEquals("Test Author", books.get(0).getAuthors().get(0).getName());
        assertEquals("Test Publishing", books.get(0).getPublishing().getName());
    }
}
