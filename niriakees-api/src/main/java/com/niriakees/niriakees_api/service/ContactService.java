package com.niriakees.niriakees_api.service;

import com.niriakees.niriakees_api.modele.Contact;
import com.niriakees.niriakees_api.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Récupérer tous les contacts
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    // Récupérer un contact par ID de façon sécurisée
    public Contact getById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null); // renvoie null si non trouvé
    }

    // Créer ou mettre à jour un contact
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    // Supprimer un contact par ID
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
