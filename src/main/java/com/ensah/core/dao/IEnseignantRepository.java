package com.ensah.core.dao;

import com.ensah.core.bo.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ensah.core.bo.Enseignant;

import java.util.List;

public interface IEnseignantRepository extends JpaRepository<Enseignant, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ic
}
