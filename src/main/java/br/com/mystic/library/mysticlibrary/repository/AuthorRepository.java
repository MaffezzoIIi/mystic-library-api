package br.com.mystic.library.mysticlibrary.repository;

import br.com.mystic.library.mysticlibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
