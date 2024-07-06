package br.com.mystic.library.mysticlibrary.service;

import br.com.mystic.library.mysticlibrary.model.Publishing;
import br.com.mystic.library.mysticlibrary.repository.PublishingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublishingService {

    @Autowired
    private PublishingRepository publishingRepository;

    public List<Publishing> findAll() {
        return publishingRepository.findAll();
    }

    public Optional<Publishing> findById(Long id) {
        return publishingRepository.findById(id);
    }

    public Publishing save(Publishing publishing) {
        return publishingRepository.save(publishing);
    }

    public void deleteById(Long id) {
        publishingRepository.deleteById(id);
    }
}
