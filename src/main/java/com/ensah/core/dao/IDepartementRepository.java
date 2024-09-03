package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Departement;

public interface IDepartementRepository extends JpaRepository<Departement, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici
}
