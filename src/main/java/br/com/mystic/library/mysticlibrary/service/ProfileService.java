package br.com.mystic.library.mysticlibrary.service;

import br.com.mystic.library.mysticlibrary.model.Profile;
import br.com.mystic.library.mysticlibrary.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProfileService {


    public Profile createDefaultProfile(User user) {
        Profile profile = new Profile();

        profile.setUser(user);
        profile.setLastLogin(LocalDate.now());
        profile.setLoginStreak(1L);

        return profile;
    }
}
