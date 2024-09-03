package com.ensah.core.services;

import com.ensah.core.bo.Surveillant;
import com.ensah.core.dao.SurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveillantService {

    private final SurveillantRepository surveillantRepository;

    @Autowired
    public SurveillantService(SurveillantRepository surveillantRepository) {
        this.surveillantRepository = surveillantRepository;
    }

    public Surveillant createSurveillant(Surveillant surveillant) {
        return surveillantRepository.save(surveillant);
    }

    public Surveillant getSurveillantById(Long id) {
        return surveillantRepository.findById(id).orElse(null);
    }

    public List<Surveillant> getAllSurveillants() {
        return surveillantRepository.findAll();
    }

    public Surveillant updateSurveillant(Long id, Surveillant surveillant) {
        Surveillant existingSurveillant = surveillantRepository.findById(id).orElse(null);
        if (existingSurveillant != null) {
            existingSurveillant.setNom(surveillant.getNom());
            existingSurveillant.setPrenom(surveillant.getPrenom());
            // Update other properties as needed
            return surveillantRepository.save(existingSurveillant);
        }
        return null;
    }


    public void deleteSurveillant(Long id) {
        surveillantRepository.deleteById(id);
    }
}
