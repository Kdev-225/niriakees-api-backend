package com.niriakees.niriakees_api.repository;

import com.niriakees.niriakees_api.modele.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {
    List<Bien> findByType(Bien.Type type);
    List<Bien> findByPrixLessThanEqual(Double prix);
}
