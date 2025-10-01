package com.niriakees.niriakees_api.repository;

import com.niriakees.niriakees_api.modele.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {}
