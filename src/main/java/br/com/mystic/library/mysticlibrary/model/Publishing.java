package br.com.mystic.library.mysticlibrary.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Publishing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publishing", cascade = CascadeType.ALL)
    private List<Book> books;

    public Publishing() {
    }

    public Publishing(Long id, String name, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.books = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
