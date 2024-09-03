package com.ensah.core.dto;

import com.ensah.core.bo.SalleSurveillant;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class ExamenForm {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    private Long id;
    @NotNull
    private String anneeUniversitaire;

    @NotNull
    private Long semestreId;

    @NotNull
    private Long sessionId;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


    @NotNull
    private Long elementPedagogiqueId;


    @NotNull
    private String heureDebut;
    @NotNull
    private Integer dureePrevue;
    @NotNull
    private Integer dureeReelle;

    private String coordonnateur;

    public Integer getDureeReelle() {
        return dureeReelle;
    }

    public void setDureeReelle(Integer dureeReelle) {
        this.dureeReelle = dureeReelle;
    }

    private List<SalleSurveillant> salleSurveillants;
    // Getters and setters
    @NotNull
    private Long typeElementId;
    @NotNull
    private Long typeExamenId;
    @NotNull
    private Long salleId;
    @NotNull
    private int nombreSurveillants;
    @NotNull
    private List<Long> enseignantsIds;
    private MultipartFile epreuve;

    private MultipartFile pv;

    public MultipartFile getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(MultipartFile epreuve) {
        this.epreuve = epreuve;
    }

    public MultipartFile getPv() {
        return pv;
    }

    public void setPv(MultipartFile pv) {
        this.pv = pv;
    }

    public String getRapportTextuel() {
        return rapportTextuel;
    }

    public void setRapportTextuel(String rapportTextuel) {
        this.rapportTextuel = rapportTextuel;
    }

    @NotNull
    private String rapportTextuel;


    // Getters and setters
    public List<Long> getEnseignantsIds() {
        return enseignantsIds;
    }

    public void setEnseignantsIds(List<Long> enseignantsIds) {
        this.enseignantsIds = enseignantsIds;
    }

    public Long getSalleId() {
        return salleId;
    }

    public void setSalleId(Long salleId) {
        this.salleId = salleId;
    }

    public int getNombreSurveillants() {
        return nombreSurveillants;
    }

    public void setNombreSurveillants(int nombreSurveillants) {
        this.nombreSurveillants = nombreSurveillants;
    }

    public Long getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(Long typeElementId) {
        this.typeElementId = typeElementId;
    }

    public Long getTypeExamenId() {
        return typeExamenId;
    }

    public void setTypeExamenId(Long typeExamenId) {
        this.typeExamenId = typeExamenId;
    }

    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public Long getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Integer getDureePrevue() {
        return dureePrevue;
    }

    public void setDureePrevue(Integer dureePrevue) {
        this.dureePrevue = dureePrevue;
    }

    public String getCoordonnateur() {
        return coordonnateur;
    }

    public void setCoordonnateur(String coordonnateur) {
        this.coordonnateur = coordonnateur;
    }

    public List<SalleSurveillant> getSalleSurveillants() {
        return salleSurveillants;
    }

    public void setSalleSurveillants(List<SalleSurveillant> salleSurveillants) {
        this.salleSurveillants = salleSurveillants;
    }

    public Long getElementPedagogiqueId() {
        return elementPedagogiqueId;
    }

    public void setElementPedagogiqueId(Long elementPedagogiqueId) {
        this.elementPedagogiqueId = elementPedagogiqueId;
    }
}