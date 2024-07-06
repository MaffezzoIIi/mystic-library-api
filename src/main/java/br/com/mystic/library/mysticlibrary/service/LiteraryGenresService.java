package br.com.mystic.library.mysticlibrary.service;

import br.com.mystic.library.mysticlibrary.model.LiteraryGenres;
import br.com.mystic.library.mysticlibrary.repository.LiteraryGenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiteraryGenresService {

    @Autowired
    private LiteraryGenresRepository literaryGenresRepository;

    public List<LiteraryGenres> findAll() {
        return literaryGenresRepository.findAll();
    }

    public Optional<LiteraryGenres> findById(Long id) {
        return literaryGenresRepository.findById(id);
    }

    public LiteraryGenres save(LiteraryGenres literaryGenres) {
        return literaryGenresRepository.save(literaryGenres);
    }

    public void deleteById(Long id) {
        literaryGenresRepository.deleteById(id);
    }
}
