package br.com.mystic.library.mysticlibrary.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class EletronicBook extends Book {

    private String format;

    public EletronicBook() {
    }

    public EletronicBook(Long id, String title, List<Author> author, Publishing publishing, String format) {
        super(id, title, author, publishing);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}