package br.com.mystic.library.mysticlibrary.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LiteraryGenres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String genre;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> author;

    public LiteraryGenres() {
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }
}
