package com.ensah.core.bo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "session")
    private Set<Examen> examens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Examen> getExamens() {
        return examens;
    }

    public void setExamens(Set<Examen> examens) {
        this.examens = examens;
    }
}
