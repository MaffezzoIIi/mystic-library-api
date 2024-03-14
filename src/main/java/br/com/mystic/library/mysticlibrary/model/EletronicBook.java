package br.com.mystic.library.mysticlibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class EletronicBook extends Book{

    @Id
    @GeneratedValue
    private Long id;

    private String format;

    public EletronicBook() {
    }

    public EletronicBook(Long id, String title, List<Author> author, Publishing publishing, Long id1, String format) {
        super(id, title, author, publishing);
        this.id = id1;
        this.format = format;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
