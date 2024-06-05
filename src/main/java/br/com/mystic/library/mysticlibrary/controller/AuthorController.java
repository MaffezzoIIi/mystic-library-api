package br.com.mystic.library.mysticlibrary.controller;

import br.com.mystic.library.mysticlibrary.DTO.AuthorDTO;
import br.com.mystic.library.mysticlibrary.model.Author;
import br.com.mystic.library.mysticlibrary.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Operation(summary = "Criação de um autor")
    @PostMapping("/create")
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }

    @GetMapping("/find/{id}")
    public AuthorDTO findAuthorById(@PathVariable Long id) throws Exception {
        return authorService.findAuthorById(id);
    }
}
