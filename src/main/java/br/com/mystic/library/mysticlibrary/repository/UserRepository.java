package br.com.mystic.library.mysticlibrary.repository;

import br.com.mystic.library.mysticlibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String>{

     UserDetails findByUsername(String username);
}
