package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ensah.core.bo.Compte;

@Repository
public interface ICompteRepository extends JpaRepository<Compte, Long> {
	Compte getCompteByLogin(String username);
}
