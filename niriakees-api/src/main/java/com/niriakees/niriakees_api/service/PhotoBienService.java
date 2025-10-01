package com.niriakees.niriakees_api.service;

import com.niriakees.niriakees_api.modele.Bien;
import com.niriakees.niriakees_api.modele.PhotoBien;
import com.niriakees.niriakees_api.repository.PhotoBienRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoBienService {

    private final PhotoBienRepository photoBienRepository;

    public PhotoBienService(PhotoBienRepository photoBienRepository) {
        this.photoBienRepository = photoBienRepository;
    }

    public List<PhotoBien> getAllPhotos() {
        return photoBienRepository.findAll();
    }

    public Optional<PhotoBien> getPhotoById(Long id) {
        return photoBienRepository.findById(id);
    }

    public PhotoBien createPhoto(PhotoBien photoBien) {
        return photoBienRepository.save(photoBien);
    }

    public PhotoBien updatePhoto(Long id, PhotoBien photoDetails) {
        return photoBienRepository.findById(id).map(photo -> {
            photo.setUrl(photoDetails.getUrl());
            photo.setBien(photoDetails.getBien());
            return photoBienRepository.save(photo);
        }).orElseThrow(() -> new RuntimeException("Photo not found"));
    }

    public void deletePhoto(Long id) {
        photoBienRepository.deleteById(id);
    }

    public List<PhotoBien> getPhotosByBien(Bien bien) {
        return photoBienRepository.findByBien(bien);
    }
}
