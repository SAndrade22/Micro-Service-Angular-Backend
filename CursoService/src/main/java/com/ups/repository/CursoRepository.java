package com.ups.repository;

import com.ups.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio JPA para operaciones CRUD en la entidad Curso
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Spring Data JPA permite la implementación automática de métodos CRUD
}
