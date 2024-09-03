package com.ensah.core.web.controllers;

import com.ensah.core.bo.Salle;
import com.ensah.core.services.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> getSalleById(@PathVariable Long id) {
        Salle salle = salleService.getSalleById(id);
        return ResponseEntity.ok(salle);
    }

    @PostMapping
    public ResponseEntity<Salle> createSalle(@RequestBody Salle salle) {
        Salle createdSalle = salleService.createSalle(salle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable Long id, @RequestBody Salle salle) {
        Salle updatedSalle = salleService.updateSalle(id, salle);
        return ResponseEntity.ok(updatedSalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return ResponseEntity.noContent().build();
    }
}
