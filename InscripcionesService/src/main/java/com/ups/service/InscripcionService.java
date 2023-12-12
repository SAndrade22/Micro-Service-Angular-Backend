package com.ups.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ups.model.Curso;
import com.ups.model.Inscripcion;
import com.ups.repository.InscripcionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
   
    
    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    // Listar todas las inscripciones
    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.findAll();
    }

    // Obtener una inscripción por su ID
    public Optional<Inscripcion> encontrarInscripcionPorId(Long id) {
        return inscripcionRepository.findById(id);
    }

    // Guardar una nueva inscripción
    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
    	try {
        return inscripcionRepository.save(inscripcion);
    	 } catch (Exception e) {
             e.printStackTrace(); // Loguea la excepción para fines de depuración
             throw new RuntimeException("Error al guardar el curso", e);
         }
    }
    
    // Eliminar una inscripción por su ID
    public void eliminarInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    // Listar inscripciones por ID de curso
    /*
    public List<Inscripcion> encontrarInscripcionesPorCurso(Long cursoId) {
        return inscripcionRepository.findByCursoId(cursoId);
    }

    // Listar inscripciones por fecha de inscripción
    public List<Inscripcion> encontrarInscripcionesPorFecha(Date fecha) {
        return inscripcionRepository.findByFechaInscripcion(fecha);
    }
    */
}
