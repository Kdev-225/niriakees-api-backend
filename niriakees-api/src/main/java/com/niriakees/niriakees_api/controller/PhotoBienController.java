package com.niriakees.niriakees_api.controller;

import com.niriakees.niriakees_api.modele.PhotoBien;
import com.niriakees.niriakees_api.service.PhotoBienService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoBienController {

    private final PhotoBienService photoBienService;

    public PhotoBienController(PhotoBienService photoBienService) {
        this.photoBienService = photoBienService;
    }

    @GetMapping
    public List<PhotoBien> getAllPhotos() {
        return photoBienService.getAllPhotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoBien> getPhotoById(@PathVariable Long id) {
        return photoBienService.getPhotoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PhotoBien createPhoto(@RequestBody PhotoBien photo) {
        return photoBienService.createPhoto(photo);
    }

    @PutMapping("/{id}")
    public PhotoBien updatePhoto(@PathVariable Long id, @RequestBody PhotoBien photo) {
        return photoBienService.updatePhoto(id, photo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long id) {
        photoBienService.deletePhoto(id);
        return ResponseEntity.noContent().build();
    }
}
