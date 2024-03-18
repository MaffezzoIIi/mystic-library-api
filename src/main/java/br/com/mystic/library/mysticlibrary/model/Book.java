package br.com.mystic.library.mysticlibrary.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Author> authors;

    @ManyToOne(cascade = CascadeType.ALL)
    private Publishing publishing;

    public Book() {
    }

    public Book(Long id, String title, List<Author> authors, Publishing publishing) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishing = publishing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publishing getPublishing() {
        return publishing;
    }

    public void setPublishing(Publishing publishing) {
        this.publishing = publishing;
    }
}
