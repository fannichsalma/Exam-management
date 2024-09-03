package com.ensah.core.bo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "idCadreAdmin")
public class CadreAdministrateur extends Personne {

	private String grade;

	@OneToMany(mappedBy = "cadreAdministrateur")
	private Set<Surveillant> surveillants;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Set<Surveillant> getSurveillants() {
		return surveillants;
	}

	public void setSurveillants(Set<Surveillant> surveillants) {
		this.surveillants = surveillants;
	}
}
