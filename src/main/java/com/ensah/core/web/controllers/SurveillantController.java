package com.ensah.core.web.controllers;
import com.ensah.core.bo.Surveillant;
import com.ensah.core.services.SurveillantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/surveillants")
public class SurveillantController {

    private final SurveillantService surveillantService;

    public SurveillantController(SurveillantService surveillantService) {
        this.surveillantService = surveillantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Surveillant> getSurveillantById(@PathVariable Long id) {
        Surveillant surveillant = surveillantService.getSurveillantById(id);
        return ResponseEntity.ok(surveillant);
    }

    @PostMapping
    public ResponseEntity<Surveillant> createSurveillant(@RequestBody Surveillant surveillant) {
        Surveillant createdSurveillant = surveillantService.createSurveillant(surveillant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSurveillant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Surveillant> updateSurveillant(@PathVariable Long id, @RequestBody Surveillant surveillant) {
        Surveillant updatedSurveillant = surveillantService.updateSurveillant(id, surveillant);
        return ResponseEntity.ok(updatedSurveillant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurveillant(@PathVariable Long id) {
        surveillantService.deleteSurveillant(id);
        return ResponseEntity.noContent().build();
    }
}
