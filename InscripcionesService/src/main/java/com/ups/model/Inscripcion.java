package com.ups.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
*/
    @Column(nullable = true)
    private String nombreCompleto;
    
    @Column(nullable = false)
    private String curso;

    @Column(nullable = false, unique = true)
    private String cedula; // Nuevo atributo cedula

    // Constructores
    public Inscripcion() {}

    public Inscripcion(String curso, String nombreCompleto, String cedula) {
        this.curso = curso;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
