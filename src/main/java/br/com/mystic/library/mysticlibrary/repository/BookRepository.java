package br.com.mystic.library.mysticlibrary.repository;

import br.com.mystic.library.mysticlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}