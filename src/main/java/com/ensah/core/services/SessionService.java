package com.ensah.core.services;
import com.ensah.core.bo.Session;
import com.ensah.core.dao.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session updateSession(Long id, Session session) {
        Session existingSession = sessionRepository.findById(id).orElse(null);
        if (existingSession != null) {
            existingSession.setId(session.getId());
            existingSession.setLibelle(session.getLibelle());
            // Update other properties as needed
            return sessionRepository.save(existingSession);
        }
        return null;
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    // Add other methods as needed

}

