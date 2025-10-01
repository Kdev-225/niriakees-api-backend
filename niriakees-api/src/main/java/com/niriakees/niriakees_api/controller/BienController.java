package com.niriakees.niriakees_api.controller;

import com.niriakees.niriakees_api.modele.Bien;
import com.niriakees.niriakees_api.service.BienService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biens")
public class BienController {

    private final BienService bienService;

    public BienController(BienService bienService) {
        this.bienService = bienService;
    }

    @GetMapping
    public List<Bien> getAllBiens() {
        return bienService.getAllBiens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bien> getBienById(@PathVariable Long id) {
        return bienService.getBienById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bien createBien(@RequestBody Bien bien) {
        return bienService.createBien(bien);
    }

    @PutMapping("/{id}")
    public Bien updateBien(@PathVariable Long id, @RequestBody Bien bien) {
        return bienService.updateBien(id, bien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBien(@PathVariable Long id) {
        bienService.deleteBien(id);
        return ResponseEntity.noContent().build();
    }
}
