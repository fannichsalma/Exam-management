package com.ensah.core.dao;

import com.ensah.core.bo.SalleSurveillant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleSurveillantRepository extends JpaRepository<SalleSurveillant, Long> {

}

