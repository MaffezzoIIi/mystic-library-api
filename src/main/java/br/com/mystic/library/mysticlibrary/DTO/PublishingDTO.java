package br.com.mystic.library.mysticlibrary.DTO;

import br.com.mystic.library.mysticlibrary.model.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class PublishingDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 554849035658224399L;

    private Long id;

    private String name;

    private List<BookDTO> books;
}
