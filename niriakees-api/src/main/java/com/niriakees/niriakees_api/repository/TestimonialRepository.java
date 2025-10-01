package com.niriakees.niriakees_api.repository;

import com.niriakees.niriakees_api.modele.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> { }
