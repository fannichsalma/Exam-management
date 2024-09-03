package com.ensah.core.bo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "examen_salle",
            joinColumns = @JoinColumn(name = "examen_id"),
            inverseJoinColumns = @JoinColumn(name = "salle_id")
    )
    private Set<Salle> salles;
    @ManyToOne
    private Semestre semestre;

    @ManyToOne
    private Session session;

    @ManyToOne
    private TypeExamen type;

    @ManyToOne
    @JoinColumn(name = "element_pedagogique_id")
    private ElementPedagogique elementPedagogique;

    private Date date;
    private String heureDebut;
    private int dureePrevue;
    private int dureeReelle;
    private String coordonnateur;

    @ManyToMany
    @JoinTable(
            name = "examen_surveillant",
            joinColumns = @JoinColumn(name = "examen_id"),
            inverseJoinColumns = @JoinColumn(name = "surveillant_id")
    )
    private List<Surveillant> surveillantsExamen;

    @ManyToMany
    @JoinTable(
            name = "examen_controleur_absence",
            joinColumns = @JoinColumn(name = "examen_id"),
            inverseJoinColumns = @JoinColumn(name = "surveillant_id")
    )
    private List<Surveillant> controleursAbsence;

    @OneToMany(mappedBy = "examen")
    private List<Surveillant> surveillants;

    @OneToMany(mappedBy = "examen")
    private List<SalleSurveillant> salleSurveillants;

    private String anneeUniversitaire;
    @Lob
    private byte[] epreuve;

    @Lob
    private byte[] pv;
    private String rapportTextuel;

    @ManyToMany
    @JoinTable(
            name = "examen_enseignant",
            joinColumns = @JoinColumn(name = "examen_id"),
            inverseJoinColumns = @JoinColumn(name = "enseignant_id")
    )
    private List<Enseignant> enseignants;

    // Getters and setters for enseignants
    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public TypeExamen getType() {
        return type;
    }

    public void setType(TypeExamen type) {
        this.type = type;
    }

    public ElementPedagogique getElementPedagogique() {
        return elementPedagogique;
    }

    public void setElementPedagogique(ElementPedagogique elementPedagogique) {
        this.elementPedagogique = elementPedagogique;
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

    public int getDureePrevue() {
        return dureePrevue;
    }

    public void setDureePrevue(int dureePrevue) {
        this.dureePrevue = dureePrevue;
    }

    public int getDureeReelle() {
        return dureeReelle;
    }

    public void setDureeReelle(int dureeReelle) {
        this.dureeReelle = dureeReelle;
    }

    public String getCoordonnateur() {
        return coordonnateur;
    }

    public void setCoordonnateur(String coordonnateur) {
        this.coordonnateur = coordonnateur;
    }

    public List<Surveillant> getSurveillantsExamen() {
        return surveillantsExamen;
    }

    public void setSurveillantsExamen(List<Surveillant> surveillantsExamen) {
        this.surveillantsExamen = surveillantsExamen;
    }

    public List<Surveillant> getControleursAbsence() {
        return controleursAbsence;
    }

    public void setControleursAbsence(List<Surveillant> controleursAbsence) {
        this.controleursAbsence = controleursAbsence;
    }

    public List<Surveillant> getSurveillants() {
        return surveillants;
    }

    public void setSurveillants(List<Surveillant> surveillants) {
        this.surveillants = surveillants;
    }

    public List<SalleSurveillant> getSalleSurveillants() {
        return salleSurveillants;
    }

    public void setSalleSurveillants(List<SalleSurveillant> salleSurveillants) {
        this.salleSurveillants = salleSurveillants;
    }

    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public byte[] getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(byte[] epreuve) {
        this.epreuve = epreuve;
    }

    public byte[] getPv() {
        return pv;
    }

    public void setPv(byte[] pv) {
        this.pv = pv;
    }

    public String getRapportTextuel() {
        return rapportTextuel;
    }

    public void setRapportTextuel(String rapportTextuel) {
        this.rapportTextuel = rapportTextuel;
    }

    public Set<Salle> getSalles() {
        return salles;
    }

    public void setSalles(Set<Salle> salles) {
        this.salles = salles;
    }
    public void addSalleSurveillant(SalleSurveillant salleSurveillant) {
        this.salleSurveillants.add(salleSurveillant);
        salleSurveillant.setExamen(this);
    }
}
