package com.ensah.core.dao;

import com.ensah.core.bo.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
