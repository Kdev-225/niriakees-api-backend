package com.niriakees.niriakees_api.controller;

import com.niriakees.niriakees_api.modele.Testimonial;
import com.niriakees.niriakees_api.service.TestimonialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {

    private final TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping
    public List<Testimonial> getAll() {
        return testimonialService.getAll();
    }

    @GetMapping("/{id}")
    public Testimonial getById(@PathVariable Long id) {
        Testimonial testimonial = testimonialService.getById(id);
        if (testimonial == null) {
            throw new RuntimeException("Testimonial non trouvé avec l'ID : " + id);
        }
        return testimonial;
    }

    @PostMapping
    public Testimonial create(@RequestBody Testimonial testimonial) {
        return testimonialService.save(testimonial);
    }

    @PutMapping("/{id}")
    public Testimonial update(@PathVariable Long id, @RequestBody Testimonial testimonialDetails) {
        Testimonial testimonial = testimonialService.getById(id);
        if (testimonial == null) {
            throw new RuntimeException("Testimonial non trouvé avec l'ID : " + id);
        }
        testimonial.setClientName(testimonialDetails.getClientName());
        testimonial.setAvis(testimonialDetails.getAvis());
        testimonial.setNote(testimonialDetails.getNote());
        return testimonialService.save(testimonial);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        testimonialService.delete(id);
    }
}
