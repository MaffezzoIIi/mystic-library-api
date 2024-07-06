package br.com.mystic.library.mysticlibrary.repository;

import br.com.mystic.library.mysticlibrary.model.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PublishingRepository extends JpaRepository<Publishing, Long> {
}