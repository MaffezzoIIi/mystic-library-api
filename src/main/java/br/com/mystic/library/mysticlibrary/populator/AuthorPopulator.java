package br.com.mystic.library.mysticlibrary.populator;

import br.com.mystic.library.mysticlibrary.DTO.AuthorDTO;
import br.com.mystic.library.mysticlibrary.model.Author;

public class AuthorPopulator {

    public static AuthorDTO populateAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());

        return authorDTO;
    }
}
