package br.com.mystic.library.mysticlibrary.repository;

import br.com.mystic.library.mysticlibrary.model.LiteraryGenres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteraryGenresRepository extends JpaRepository<LiteraryGenres, Long> {
}