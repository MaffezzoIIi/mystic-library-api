package br.com.mystic.library.mysticlibrary.DTO;

import br.com.mystic.library.mysticlibrary.enums.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
