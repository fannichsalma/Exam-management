package com.ensah.core.bo;

import jakarta.persistence.*;



@Entity
@Table(name = "element_pedagogique")
public class ElementPedagogique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "coordonnateur_id")
    private Enseignant coordonnateur;

    @ManyToOne
    @JoinColumn(name = "type_element_id")
    private TypeElement typeElement;

    // Constructeur par défaut
    public ElementPedagogique() {}

    // Constructeur avec arguments
    public ElementPedagogique(String titre, Niveau niveau, Enseignant coordonnateur, TypeElement typeElement) {
        this.titre = titre;
        this.niveau = niveau;
        this.coordonnateur = coordonnateur;
        this.typeElement = typeElement;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Enseignant getCoordonnateur() {
        return coordonnateur;
    }

    public void setCoordonnateur(Enseignant coordonnateur) {
        this.coordonnateur = coordonnateur;
    }

    public TypeElement getTypeElement() {
        return typeElement;
    }

    public void setTypeElement(TypeElement typeElement) {
        this.typeElement = typeElement;
    }
}