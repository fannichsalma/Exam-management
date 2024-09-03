package com.ensah.core.web.controllers;


import com.ensah.core.bo.TypeExamen;
import com.ensah.core.services.TypeExamenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeExamens")
public class TypeExamenController {

    private final TypeExamenService typeExamenService;

    public TypeExamenController(TypeExamenService typeExamenService) {
        this.typeExamenService = typeExamenService;
    }

    @GetMapping
    public ResponseEntity<List<TypeExamen>> getAllTypeExamens() {
        List<TypeExamen> typeExamens = typeExamenService.getAllTypeExamens();
        return ResponseEntity.ok(typeExamens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeExamen> getTypeExamenById(@PathVariable Long id) {
        TypeExamen typeExamen = typeExamenService.getTypeExamenById(id);
        return ResponseEntity.ok(typeExamen);
    }

    @PostMapping
    public ResponseEntity<TypeExamen> createTypeExamen(@RequestBody TypeExamen typeExamen) {
        TypeExamen createdTypeExamen = typeExamenService.createTypeExamen(typeExamen);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeExamen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeExamen> updateTypeExamen(@PathVariable Long id, @RequestBody TypeExamen typeExamen) {
        TypeExamen updatedTypeExamen = typeExamenService.updateTypeExamen(id, typeExamen);
        return ResponseEntity.ok(updatedTypeExamen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeExamen(@PathVariable Long id) {
        typeExamenService.deleteTypeExamen(id);
        return ResponseEntity.noContent().build();
    }
}

