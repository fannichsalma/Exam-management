package com.ensah.core.services;
import com.ensah.core.bo.Examen;
import com.ensah.core.bo.TypeExamen;
import com.ensah.core.dao.ExamenRepository;
import com.ensah.core.dao.TypeExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class TypeExamenService {

    @Autowired
    private TypeExamenRepository typeExamenRepository;

    @Autowired
    private ExamenRepository examenRepository; // Exemple d'une relation avec Examen, à adapter selon votre modèle

    public List<TypeExamen> getAllTypeExamens() {
        return typeExamenRepository.findAll();
    }

    public TypeExamen getTypeExamenById(Long id) {
        return typeExamenRepository.findById(id).orElse(null);
    }

    public TypeExamen createTypeExamen(TypeExamen typeExamen) {
        return typeExamenRepository.save(typeExamen);
    }

    public TypeExamen updateTypeExamen(Long id, TypeExamen typeExamen) {
        TypeExamen existingTypeExamen = typeExamenRepository.findById(id).orElse(null);
        if (existingTypeExamen != null) {
            existingTypeExamen.setLibelle(typeExamen.getLibelle());
            // Update other properties as needed
            return typeExamenRepository.save(existingTypeExamen);
        }
        return null;
    }

    public void deleteTypeExamen(Long id) {
        typeExamenRepository.deleteById(id);
    }

    public List<Examen> getExamensByTypeExamen(Long typeExamenId) {
        TypeExamen typeExamen = typeExamenRepository.findById(typeExamenId).orElse(null);
        if (typeExamen != null) {
            return (List<Examen>) typeExamen.getExamens();
        }
        return Collections.emptyList();
    }

    // Add other methods as needed

}

