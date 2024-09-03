package com.ensah.core.services;

import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService {
    private final NiveauRepository niveauRepository;

    @Autowired
    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    public Niveau getNiveauById(Long id) {
        return niveauRepository.findById(id).orElseThrow(() -> new RuntimeException("Niveau non trouvé avec l'ID : " + id));
    }

}
