package com.ensah.core.services;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.dao.IEnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {
    private final IEnseignantRepository enseignantRepository;

    @Autowired
    public EnseignantService(IEnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id).orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec l'ID : " + id));
    }


    public List<Enseignant> getAllEnseignantsByIds(List<Long> ids) {
        return enseignantRepository.findAllById(ids);
    }
}
