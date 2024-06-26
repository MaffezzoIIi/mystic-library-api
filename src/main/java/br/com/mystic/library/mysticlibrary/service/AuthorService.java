package br.com.mystic.library.mysticlibrary.service;

import br.com.mystic.library.mysticlibrary.DTO.AuthorDTO;
import br.com.mystic.library.mysticlibrary.model.Author;
import br.com.mystic.library.mysticlibrary.populator.AuthorPopulator;
import br.com.mystic.library.mysticlibrary.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private Author save(Author author) {
        return authorRepository.save(author);
    }

    private Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author toSave = new Author();

        toSave.setName(authorDTO.getName());

        return AuthorPopulator.populateAuthorDTO(save(toSave));
    }

    public ResponseEntity<AuthorDTO> findAuthorById(Long id) throws Exception {
        Optional<Author> author = findById(id);

        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        AuthorDTO authorDTO = AuthorPopulator.populateAuthorDTO(author.get());
        return ResponseEntity.ok(authorDTO);
    }
}
