package br.com.mystic.library.mysticlibrary.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;

public class BookTest {

    private Book book;
    private Author author;
    private Publishing publishing;

    @BeforeEach
    public void setUp() {
        book = new Book();
        author = new Author();
        publishing = new Publishing();

        author.setName("Nome teste");
        List<Author> authors = new ArrayList<>();
        authors.add(author);

        publishing.setName("Editora");

        book.setTitle("Livro");
        book.setAuthors(authors);
        book.setPublishing(publishing);
    }

    @Test
    public void testBookFields() {
        assertEquals("Livro", book.getTitle());
        assertEquals(1, book.getAuthors().size());
        assertEquals("Nome teste", book.getAuthors().get(0).getName());
        assertEquals("Editora", book.getPublishing().getName());
    }
}
