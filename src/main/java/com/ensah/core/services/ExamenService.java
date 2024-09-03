package com.ensah.core.services;

import com.ensah.core.bo.*;
import com.ensah.core.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenService {
    @Autowired
    private  ExamenRepository examenRepository;
    @Autowired
    private  SemestreRepository semestreRepository;
    @Autowired
    private  SessionRepository sessionRepository;
    @Autowired
    private  TypeExamenRepository typeExamenRepository;
    @Autowired
    private  SalleRepository salleRepository;



    public List<Examen> getAllExamens() {
        return examenRepository.findAll();
    }

    public Examen getExamenById(Long id) {
        return examenRepository.findById(id).orElse(null);
    }

    public Examen saveExamen(Examen examen) {
        return examenRepository.save(examen);
    }



    public void deleteExamen(Long id) {
        examenRepository.deleteById(id);
    }

    public List<Semestre> getAllSemestres() {
        return semestreRepository.findAll();
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public List<TypeExamen> getAllTypeExamens() {
        return typeExamenRepository.findAll();
    }
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

}
