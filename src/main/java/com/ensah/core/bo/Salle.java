package com.ensah.core.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int capacite;
    private int nombreSurveillants;

    @OneToMany(mappedBy = "salle")
    private Set<Surveillant> surveillants;
    @ManyToMany(mappedBy = "salles")
    private Set<Examen> examens;

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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Set<Surveillant> getSurveillants() {
        return surveillants;
    }

    public void setSurveillants(Set<Surveillant> surveillants) {
        this.surveillants = surveillants;
    }


    public int getNombreSurveillants() {
        return nombreSurveillants;
    }

    public void setNombreSurveillants(int nombreSurveillants) {
        this.nombreSurveillants = nombreSurveillants;
    }
}
