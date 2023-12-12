package com.ups.model;

// Entidad JPA que representa un curso en la base de datos
public class Curso {
	
    private Long id;
    private String nombre;
    private String descripcion;

    public Curso() {
    	super();
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


