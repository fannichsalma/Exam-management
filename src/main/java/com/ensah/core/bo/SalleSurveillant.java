package com.ensah.core.bo;

import jakarta.persistence.*;

@Entity
public class SalleSurveillant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    private int nombreSurveillants;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public int getNombreSurveillants() {
        return nombreSurveillants;
    }

    public void setNombreSurveillants(int nombreSurveillants) {
        this.nombreSurveillants = nombreSurveillants;
    }
}
