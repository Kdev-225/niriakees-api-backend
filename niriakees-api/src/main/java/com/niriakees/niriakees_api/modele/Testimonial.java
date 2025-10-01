package com.niriakees.niriakees_api.modele;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "testimonial")
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String avis;

    @Column(nullable = false)
    private int note;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public String getAvis() { return avis; }
    public void setAvis(String avis) { this.avis = avis; }
    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
