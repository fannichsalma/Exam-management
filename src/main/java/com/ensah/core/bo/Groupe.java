package com.ensah.core.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Groupe")
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;

    private String nomGroupe;
    private String typeGroupe;

    @ManyToOne
    @JoinColumn(name = "idFiliere")
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name = "idDepartement")
    private Departement departement;

    @OneToMany(mappedBy = "groupe")
    private List<Enseignant> enseignants;

    @ManyToMany(mappedBy = "groupes")
    private Set<Enseignant> enseignantss;

    public Set<Enseignant> getEnseignantss() {
        return enseignantss;
    }

    public void setEnseignants(Set<Enseignant> enseignantss) {
        this.enseignantss = enseignantss;
    }

    // Getters, setters et constructeur

    public Long getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Long idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public String getTypeGroupe() {
        return typeGroupe;
    }

    public void setTypeGroupe(String typeGroupe) {
        this.typeGroupe = typeGroupe;
    }

    public void setEnseignantss(HashSet<Enseignant> enseignantss) {
        this.enseignantss = enseignantss;
    }
}
