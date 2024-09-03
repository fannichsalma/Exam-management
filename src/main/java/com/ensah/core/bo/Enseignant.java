package com.ensah.core.bo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseignant")
public class Enseignant extends Personne {

	private String specialite;

	@ManyToOne
	@JoinColumn(name = "idFiliere")
	private Filiere filiere;

	@ManyToOne
	@JoinColumn(name = "idDepartement")
	private Departement departement;

	@ManyToOne
	@JoinColumn(name = "idGroupe")
	private Groupe groupe;

	@ManyToMany
	@JoinTable(
			name = "Enseignant_Filiere",
			joinColumns = @JoinColumn(name = "idEnseignant"),
			inverseJoinColumns = @JoinColumn(name = "idFiliere")
	)

	private Set<Filiere> filieres;

	@ManyToMany(mappedBy = "enseignants")
	private List<Examen> examens;
	@ManyToMany
	@JoinTable(
			name = "Enseignant_Groupe",
			joinColumns = @JoinColumn(name = "idEnseignant"),
			inverseJoinColumns = @JoinColumn(name = "idGroupe")
	)
	private Set<Groupe> groupes;
	// Getters and setters for examens
	public Set<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}
	public List<Examen> getExamens() {
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	// Getters et Setters

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Set<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(Set<Filiere> filieres) {
		this.filieres = filieres;
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

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	// Ajouter un getter pour idPersonne
	public Long getIdPersonne() {
		return super.getIdPersonne();
	}
}
