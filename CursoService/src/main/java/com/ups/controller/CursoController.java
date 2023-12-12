package com.ups.controller;

import com.ups.model.Curso;
import com.ups.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
@RestController
@RequestMapping("/cursos")
public class CursoController {
*/
	
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {	
	
    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Maneja la petición GET para obtener todos los cursos
    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.findAllCursos();
    }

    // Maneja la petición GET para obtener un curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        return cursoService.findCursoById(id)
                .map(curso -> ResponseEntity.ok(curso))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> createCurso(@RequestBody Curso curso) {
        try {
            Curso createdCurso = cursoService.saveCurso(curso);
            return ResponseEntity.ok(createdCurso);
        } catch (Exception e) {
            e.printStackTrace(); // Loguea la excepción para fines de depuración
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }

    // Maneja la petición PUT para actualizar un curso existente
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.updateCurso(id, curso));
    }

    // Maneja la petición DELETE para eliminar un curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
        return ResponseEntity.ok().build();
    }
}
