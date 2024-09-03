package com.ensah.core.web.controllers;

import com.ensah.core.bo.Semestre;
import com.ensah.core.services.SemestreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/semestres")
public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semestre> getSemestreById(@PathVariable Long id) {
        Semestre semestre = semestreService.getSemestreById(id);
        return ResponseEntity.ok(semestre);
    }

    @PostMapping
    public ResponseEntity<Semestre> createSemestre(@RequestBody Semestre semestre) {
        Semestre createdSemestre = semestreService.createSemestre(semestre);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSemestre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semestre> updateSemestre(@PathVariable Long id, @RequestBody Semestre semestre) {
        Semestre updatedSemestre = semestreService.updateSemestre(id, semestre);
        return ResponseEntity.ok(updatedSemestre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.noContent().build();
    }
}
