package com.ensah.core.bo;


import java.util.*;

import jakarta.persistence.*;


@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idType;

	private String nomType;

	@OneToMany(mappedBy = "Type", cascade = CascadeType.ALL , targetEntity = Compte.class)
	private Set<Compte> comptes;

	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
}