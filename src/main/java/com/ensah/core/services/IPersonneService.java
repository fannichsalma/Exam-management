package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Departement;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Personne;
import com.ensah.core.utils.ExcelExporter;

public interface IPersonneService {

	public void addPersonne(Personne pPerson);

	public void updatePersonne(Personne pPerson);

	public List<Personne> getAllPersonnes();

	public void deletePersonne(Long id);

	public Personne getPersonneById(Long id);
	
	public Personne getPersonneByCin(String cin);
	
	public ExcelExporter preparePersonneExport(List<Personne> persons);

	public  List<Enseignant> getAllEnseignants();
	public  List<Filiere> getAllFilieres();
	public  List<Departement> getAllDepartements();
	

}
