package com.ensah.core.bo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Surveillant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String emploiDuTemps; // Représente l'emploi du temps du surveillant

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "cadre_admin_id")
    private CadreAdministrateur cadreAdministrateur;

    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    @ManyToMany
    @JoinTable(
            name = "Surveillant_Enseignant",
            joinColumns = @JoinColumn(name = "surveillant_id"),
            inverseJoinColumns = @JoinColumn(name = "enseignant_id")
    )
    private Set<Enseignant> enseignants;

    // Getters et Setters
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public CadreAdministrateur getCadreAdministrateur() {
        return cadreAdministrateur;
    }

    public void setCadreAdministrateur(CadreAdministrateur cadreAdministrateur) {
        this.cadreAdministrateur = cadreAdministrateur;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
    public String getEmploiDuTemps() {
        return emploiDuTemps;
    }

    public void setEmploiDuTemps(String emploiDuTemps) {
        this.emploiDuTemps = emploiDuTemps;
    }
}
