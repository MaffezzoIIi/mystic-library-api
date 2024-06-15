package br.com.mystic.library.mysticlibrary.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private JwtEncoder encoder;

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        long expiration = now.getEpochSecond() + 3600;

        String scopes = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder().issuer("mystic-library")
                .subject(authentication.getName())
                .issuedAt(now).expiresAt(Instant.ofEpochSecond(expiration)).subject(authentication.getName()).claim("scope", scopes).build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
