package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;

    private String nomFiliere;

    @ManyToMany(mappedBy = "filieres")
    private Set<Enseignant> enseignants;

    // Getters, setters et autres méthodes


    public Long getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
}