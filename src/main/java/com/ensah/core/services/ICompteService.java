package com.ensah.core.services;

import java.util.List;


import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Type;
import com.ensah.core.utils.ExcelExporter;


public interface ICompteService {
	
	public List<Type> getAllTypes();
	
	public List<Compte> getAllAccounts();
	
	public Compte getAccountByUserName(String login);
	
	public String createUser(Long idType, Long idPerson);
	
	public ExcelExporter prepareCompteExport(List<Compte> comptes) ;
}
