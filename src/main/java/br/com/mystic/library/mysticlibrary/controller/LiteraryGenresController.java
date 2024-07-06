package br.com.mystic.library.mysticlibrary.controller;

import br.com.mystic.library.mysticlibrary.model.LiteraryGenres;
import br.com.mystic.library.mysticlibrary.service.LiteraryGenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/literary-genres")
public class LiteraryGenresController {

    @Autowired
    private LiteraryGenresService literaryGenresService;

    @GetMapping
    public List<LiteraryGenres> findAll() {
        return literaryGenresService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LiteraryGenres> findById(@PathVariable Long id) {
        Optional<LiteraryGenres> literaryGenres = literaryGenresService.findById(id);
        return literaryGenres.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public LiteraryGenres save(@RequestBody LiteraryGenres literaryGenres) {
        return literaryGenresService.save(literaryGenres);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        literaryGenresService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
