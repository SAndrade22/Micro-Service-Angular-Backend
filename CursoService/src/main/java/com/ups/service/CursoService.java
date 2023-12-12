package com.ups.service;

import com.ups.model.Curso;
import com.ups.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Devuelve todos los cursos
    public List<Curso> findAllCursos() {
        return cursoRepository.findAll();
    }

    // Busca un curso por su ID
    public Optional<Curso> findCursoById(Long id) {
        return cursoRepository.findById(id);
    }
    
    public Curso saveCurso(Curso curso) {
        try {
            return cursoRepository.save(curso);
        } catch (Exception e) {
            e.printStackTrace(); // Loguea la excepción para fines de depuración
            throw new RuntimeException("Error al guardar el curso", e);
        }
    }


    // Elimina un curso por su ID
    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    // Actualiza la información de un curso existente
    public Curso updateCurso(Long id, Curso curso) {
        return cursoRepository.findById(id)
                .map(existingCurso -> {
                    existingCurso.setNombre(curso.getNombre());
                    existingCurso.setDescripcion(curso.getDescripcion());
                    return cursoRepository.save(existingCurso);
                })
                .orElseGet(() -> {
                    curso.setId(id);
                    return cursoRepository.save(curso);
                });
    }
}
