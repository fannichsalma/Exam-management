package com.ensah.core.dto;

public class ElementPedagogiqueForm {

    private Long id;
    private String titre;
    private Long niveauId;
    private Long coordonnateurId;
    private Long typeElementId;


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

    public Long getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(Long niveauId) {
        this.niveauId = niveauId;
    }

    public Long getCoordonnateurId() {
        return coordonnateurId;
    }

    public void setCoordonnateurId(Long coordonnateurId) {
        this.coordonnateurId = coordonnateurId;
    }

    public Long getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(Long typeElementId) {
        this.typeElementId = typeElementId;
    }


}
