package com.niriakees.niriakees_api.service;

import com.niriakees.niriakees_api.modele.Bien;
import com.niriakees.niriakees_api.repository.BienRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BienService {

    private final BienRepository bienRepository;

    public BienService(BienRepository bienRepository) {
        this.bienRepository = bienRepository;
    }

    public List<Bien> getAllBiens() {
        return bienRepository.findAll();
    }

    public Optional<Bien> getBienById(Long id) {
        return bienRepository.findById(id);
    }

    public Bien createBien(Bien bien) {
        return bienRepository.save(bien);
    }

    public Bien updateBien(Long id, Bien bienDetails) {
        return bienRepository.findById(id).map(bien -> {
            bien.setTitre(bienDetails.getTitre());
            bien.setDescription(bienDetails.getDescription());
            bien.setAdresse(bienDetails.getAdresse());
            bien.setType(bienDetails.getType());
            bien.setPrix(bienDetails.getPrix());
            return bienRepository.save(bien);
        }).orElseThrow(() -> new RuntimeException("Bien not found"));
    }

    public void deleteBien(Long id) {
        bienRepository.deleteById(id);
    }

    public List<Bien> getBiensByType(Bien.Type type) {
        return bienRepository.findByType(type);
    }
}
