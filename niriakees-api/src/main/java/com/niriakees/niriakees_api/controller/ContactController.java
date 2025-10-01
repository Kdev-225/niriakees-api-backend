package com.niriakees.niriakees_api.controller;

import com.niriakees.niriakees_api.modele.Contact;
import com.niriakees.niriakees_api.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Récupérer tous les contacts
    @GetMapping
    public List<Contact> getAll() {
        return contactService.getAll();
    }

    // Récupérer un contact par ID
    @GetMapping("/{id}")
    public Contact getById(@PathVariable Long id) {
        Contact contact = contactService.getById(id);
        if (contact == null) {
            throw new RuntimeException("Contact non trouvé avec l'ID : " + id);
        }
        return contact;
    }

    // Créer un contact
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    // Mettre à jour un contact
    @PutMapping("/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact contactDetails) {
        Contact contact = contactService.getById(id);
        if (contact == null) {
            throw new RuntimeException("Contact non trouvé avec l'ID : " + id);
        }
        contact.setNom(contactDetails.getNom());
        contact.setEmail(contactDetails.getEmail());
        contact.setMessage(contactDetails.getMessage());
        return contactService.save(contact);
    }

    // Supprimer un contact
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactService.delete(id);
    }
}
