package br.com.mystic.library.mysticlibrary.controller;

import br.com.mystic.library.mysticlibrary.model.Publishing;
import br.com.mystic.library.mysticlibrary.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishings")
public class PublishingController {

    @Autowired
    private PublishingService publishingService;

    @GetMapping
    public List<Publishing> findAll() {
        return publishingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publishing> findById(@PathVariable Long id) {
        Optional<Publishing> publishing = publishingService.findById(id);
        return publishing.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publishing save(@RequestBody Publishing publishing) {
        return publishingService.save(publishing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        publishingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
