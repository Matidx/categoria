package com.categoria.entity;

import com.categoria.enums.CategoriaTrabajo;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull
    private String nombre;
    private CategoriaTrabajo categoriaTrabajo;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<PlataformaDigital> permisos = new HashSet<>();

    // Getters y setters
    public Set<PlataformaDigital> getPermisos() {
        return permisos;
    }

    public Persona() {
    }

    public Persona(Long id, String nombre, CategoriaTrabajo categoriaTrabajo, Set<PlataformaDigital> permisos) {
        this.id = id;
        this.nombre = nombre;
        this.categoriaTrabajo = categoriaTrabajo;
        this.permisos = permisos;
    }

    // Métodos para acceder a los campos (getters y setters)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaTrabajo getCategoriaTrabajo() {
        return categoriaTrabajo;
    }

    public void setCategoriaTrabajo(CategoriaTrabajo categoriaTrabajo) {
        this.categoriaTrabajo = categoriaTrabajo;
    }

    public void setPermisos(Set<PlataformaDigital> permisos) {
        this.permisos = permisos;
    }
}
