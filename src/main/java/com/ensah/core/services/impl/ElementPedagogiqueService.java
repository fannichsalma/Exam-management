package com.ensah.core.services.impl;


import com.ensah.core.dao.IElementPedagogiqueRepository;
import com.ensah.core.dao.IEnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.ensah.core.bo.ElementPedagogique;
import com.ensah.core.bo.Niveau;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.TypeElement;

import com.ensah.core.dao.NiveauRepository;

import com.ensah.core.dao.TypeElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementPedagogiqueService {

    @Autowired
    private IElementPedagogiqueRepository elementPedagogiqueRepository;

    @Autowired
    private NiveauRepository niveauRepository;

    @Autowired
    private IEnseignantRepository enseignantRepository;

    @Autowired
    private TypeElementRepository typeElementRepository;

    public List<ElementPedagogique> getAllElements() {
        return elementPedagogiqueRepository.findAll();
    }

    public List<Niveau> getNiveaux() {
        return niveauRepository.findAll();
    }

    public List<Enseignant> getEnseignants() {
        return enseignantRepository.findAll();
    }

    public List<TypeElement> getTypesElements() {
        return typeElementRepository.findAll();
    }

    public void saveElement(ElementPedagogique element) {
        elementPedagogiqueRepository.save(element);
    }
    public ElementPedagogique getElementById(Long id) {
        return elementPedagogiqueRepository.findById(id).orElse(null);
    }
    public void deleteElementById(Long id) {
        elementPedagogiqueRepository.deleteById(id);
    }

}
