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
}
