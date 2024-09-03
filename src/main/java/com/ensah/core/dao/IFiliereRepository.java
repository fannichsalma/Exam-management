package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Filiere;

public interface IFiliereRepository extends JpaRepository<Filiere, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici
}
