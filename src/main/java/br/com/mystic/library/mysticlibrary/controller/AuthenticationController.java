package br.com.mystic.library.mysticlibrary.controller;

import br.com.mystic.library.mysticlibrary.DTO.AuthenticationDTO;
import br.com.mystic.library.mysticlibrary.DTO.LoginResponseDTO;
import br.com.mystic.library.mysticlibrary.DTO.RegisterDTO;
import br.com.mystic.library.mysticlibrary.model.Publishing;
import br.com.mystic.library.mysticlibrary.model.User;
import br.com.mystic.library.mysticlibrary.repository.UserRepository;
import br.com.mystic.library.mysticlibrary.service.AuthenticationService;
import br.com.mystic.library.mysticlibrary.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    public AuthenticationController(AuthenticationService authenticationService, AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authentication) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authentication.username(), authentication.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = jwtService.generateToken((User) authenticate.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if(userRepository.findByUsername(registerDTO.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());

        User user = new User(registerDTO.username(), encryptedPassword, registerDTO.role());

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }
}
