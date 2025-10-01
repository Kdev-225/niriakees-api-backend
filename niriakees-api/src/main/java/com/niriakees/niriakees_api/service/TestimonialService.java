package com.niriakees.niriakees_api.service;

import com.niriakees.niriakees_api.modele.Testimonial;
import com.niriakees.niriakees_api.repository.TestimonialRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialService(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    public List<Testimonial> getAll() {
        return testimonialRepository.findAll();
    }

    public Testimonial save(Testimonial testimonial) {
        return testimonialRepository.save(testimonial);
    }

    public Testimonial getById(Long id) {
        return testimonialRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        testimonialRepository.deleteById(id);
    }
}
