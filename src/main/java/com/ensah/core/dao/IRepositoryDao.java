package com.ensah.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Type;

public interface IRepositoryDao extends JpaRepository<Type, Long> {

}
