package com.nadia.entreprise.repos;

import com.nadia.entreprise.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    Entreprise findByCodeEnt(String code);
}