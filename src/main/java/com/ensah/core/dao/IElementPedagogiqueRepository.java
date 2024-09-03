package com.ensah.core.dao;

import com.ensah.core.bo.ElementPedagogique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IElementPedagogiqueRepository extends JpaRepository<ElementPedagogique, Long> {
    // Définition des méthodes pour les opérations de base
    List<ElementPedagogique> findAll();


    Optional<ElementPedagogique> findById(Long id);

    ElementPedagogique save(ElementPedagogique elementPedagogique);

    void deleteById(Long id);
}