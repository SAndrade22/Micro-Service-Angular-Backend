package com.ups.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.model.Inscripcion;

import java.util.Date;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Consultas personalizadas
/*
    List<Inscripcion> findByCursoId(Long cursoId);

    List<Inscripcion> findByFechaInscripcion(Date fecha);
    */
}
