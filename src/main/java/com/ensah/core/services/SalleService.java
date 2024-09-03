package com.ensah.core.services;

import com.ensah.core.bo.Salle;
import com.ensah.core.bo.SalleSurveillant;
import com.ensah.core.dao.SalleRepository;
import com.ensah.core.dao.SalleSurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private SalleSurveillantRepository salleSurveillantRepository;

    public Salle updateSalle(Long id, Salle salle) {
        Salle existingSalle = salleRepository.findById(id).orElse(null);
        if (existingSalle != null) {
            existingSalle.setNom(salle.getNom());
            existingSalle.setCapacite(salle.getCapacite());

            return salleRepository.save(existingSalle);
        }
        return null;
    }

    public void saveSalleSurveillant(SalleSurveillant salleSurveillant) {
        salleSurveillantRepository.save(salleSurveillant);
    }

    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    public Salle getSalleById(Long id) {
        return salleRepository.findById(id).orElse(null);
    }

    public Salle createSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    // Ajoutez d'autres méthodes selon les besoins

}

