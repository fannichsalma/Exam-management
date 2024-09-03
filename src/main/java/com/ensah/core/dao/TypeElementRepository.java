package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensah.core.bo.TypeElement;

@Repository
public interface TypeElementRepository extends JpaRepository<TypeElement, Long> {
}
