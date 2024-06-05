package br.com.mystic.library.mysticlibrary.DTO;

import br.com.mystic.library.mysticlibrary.model.Author;
import br.com.mystic.library.mysticlibrary.model.Publishing;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class BookDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 258843157061015472L;

    private Long id;

    private String title;

    private List<AuthorDTO> authors;

    private Publishing publishing;
}
