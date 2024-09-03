package com.ensah.core.bo;

import jakarta.persistence.*;

@Entity
public class ControleurAbsence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String emploiDuTemps; // Représente l'emploi du temps du contrôleur

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmploiDuTemps() {
        return emploiDuTemps;
    }

    public void setEmploiDuTemps(String emploiDuTemps) {
        this.emploiDuTemps = emploiDuTemps;
    }
}
