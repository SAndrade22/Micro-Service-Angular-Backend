package com.ups.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ups.model.Curso;
import com.ups.model.Inscripcion;
import com.ups.service.InscripcionService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;
    
    

    @Autowired
    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    // Listar todas las inscripciones
    @GetMapping
    public ResponseEntity<List<Inscripcion>> listarInscripciones() {
        List<Inscripcion> inscripciones = inscripcionService.listarInscripciones();
        return ResponseEntity.ok(inscripciones);
    }

    // Obtener una inscripción por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> encontrarInscripcionPorId(@PathVariable Long id) {
        Optional<Inscripcion> inscripcion = inscripcionService.encontrarInscripcionPorId(id);
        return inscripcion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar una nueva inscripción
    @PostMapping
    public ResponseEntity<?> guardarInscripcion(@RequestBody Inscripcion inscripcion) {
        Inscripcion savedInscripcion = inscripcionService.guardarInscripcion(inscripcion);
        return ResponseEntity.ok(savedInscripcion);
    }

    // Eliminar una inscripción por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable Long id) {
        inscripcionService.eliminarInscripcion(id);
        return ResponseEntity.noContent().build();
    }
/*
    // Listar inscripciones por ID de curso
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Inscripcion>> encontrarInscripcionesPorCurso(@PathVariable Long cursoId) {
        List<Inscripcion> inscripciones = inscripcionService.encontrarInscripcionesPorCurso(cursoId);
        return ResponseEntity.ok(inscripciones);
    }

    // Listar inscripciones por fecha de inscripción
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Inscripcion>> encontrarInscripcionesPorFecha(@PathVariable Date fecha) {
        List<Inscripcion> inscripciones = inscripcionService.encontrarInscripcionesPorFecha(fecha);
        return ResponseEntity.ok(inscripciones);
    }
    /*
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Inscripcion>> obtenerInscripcionesPorCurso(@PathVariable Long cursoId) {
		return null;
        // Lógica para obtener las inscripciones por cursoId
    }
    */
    
}
