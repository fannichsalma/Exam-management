package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
}
