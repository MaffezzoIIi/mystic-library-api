package br.com.mystic.library.mysticlibrary.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "athours", cascade = CascadeType.ALL)
    private List<Author> author;

    @ManyToOne(cascade = CascadeType.ALL)
    private Publishing publishing;

    public Book() {
    }

    public Book(Long id, String title, List<Author> author, Publishing publishing) {
        this.id = id;
        this.title = title;
        this.author = author;
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

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public Publishing getPublishing() {
        return publishing;
    }

    public void setPublishing(Publishing publishing) {
        this.publishing = publishing;
    }
}
