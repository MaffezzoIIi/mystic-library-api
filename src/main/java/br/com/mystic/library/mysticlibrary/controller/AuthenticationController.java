package br.com.mystic.library.mysticlibrary.controller;

import br.com.mystic.library.mysticlibrary.DTO.AuthenticationDTO;
import br.com.mystic.library.mysticlibrary.DTO.LoginResponseDTO;
import br.com.mystic.library.mysticlibrary.DTO.RegisterDTO;
import br.com.mystic.library.mysticlibrary.model.Profile;
import br.com.mystic.library.mysticlibrary.model.User;
import br.com.mystic.library.mysticlibrary.repository.UserRepository;
import br.com.mystic.library.mysticlibrary.service.AuthenticationService;
import br.com.mystic.library.mysticlibrary.service.JwtService;
import br.com.mystic.library.mysticlibrary.service.LoginService;
import br.com.mystic.library.mysticlibrary.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final LoginService loginService;
    private final UserRepository userRepository;
    private ProfileService profileService;


    public AuthenticationController(AuthenticationService authenticationService, AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService, LoginService loginService, ProfileService profileService) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
        this.loginService = loginService;
        this.profileService = profileService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO authentication) {
        return ResponseEntity.ok(loginService.login(authentication));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if(userRepository.findByUsername(registerDTO.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());

        User user = new User(registerDTO.username(), encryptedPassword, registerDTO.role());
        user.setProfile(profileService.createDefaultProfile(user));

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }
}
