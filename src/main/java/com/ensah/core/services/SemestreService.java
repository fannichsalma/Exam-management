package com.ensah.core.services;
import com.ensah.core.bo.Semestre;
import com.ensah.core.dao.ExamenRepository;
import com.ensah.core.dao.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    @Autowired
    private ExamenRepository examenRepository; // Exemple d'une relation avec Examen, à adapter selon votre modèle

    public List<Semestre> getAllSemestres() {
        return semestreRepository.findAll();
    }

    public Semestre getSemestreById(Long id) {
        return semestreRepository.findById(id).orElse(null);
    }

    public Semestre createSemestre(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    public Semestre updateSemestre(Long id, Semestre semestre) {
        Semestre existingSemestre = semestreRepository.findById(id).orElse(null);
        if (existingSemestre != null) {
            existingSemestre.setLibelle(semestre.getLibelle());
            existingSemestre.setDateDebut(semestre.getDateDebut());
            existingSemestre.setDateFin(semestre.getDateFin());
            existingSemestre.setExamens(semestre.getExamens());

            return semestreRepository.save(existingSemestre);
        }
        return null;
    }

    public void deleteSemestre(Long id) {
        semestreRepository.deleteById(id);
    }
}

