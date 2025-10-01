package com.niriakees.niriakees_api.repository;

import com.niriakees.niriakees_api.modele.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> { }
