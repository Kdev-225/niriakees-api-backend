package com.niriakees.niriakees_api.repository;

import com.niriakees.niriakees_api.modele.PhotoBien;
import com.niriakees.niriakees_api.modele.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoBienRepository extends JpaRepository<PhotoBien, Long> {
    List<PhotoBien> findByBien(Bien bien);
}
