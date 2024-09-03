package com.ensah.core.dao;

import com.ensah.core.bo.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Filiere;

public interface IGroupeRepository extends JpaRepository<Groupe, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici
}

