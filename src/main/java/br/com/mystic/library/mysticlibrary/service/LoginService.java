package br.com.mystic.library.mysticlibrary.service;

import br.com.mystic.library.mysticlibrary.DTO.AuthenticationDTO;
import br.com.mystic.library.mysticlibrary.DTO.LoginResponseDTO;
import br.com.mystic.library.mysticlibrary.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public LoginService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public LoginResponseDTO login(AuthenticationDTO authentication) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authentication.username(), authentication.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = jwtService.generateToken((User) authenticate.getPrincipal());

        return new LoginResponseDTO(token);
    }

}
