package com.categoria.repository;

import com.categoria.enums.CategoriaTrabajo;
import com.categoria.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByCategoriaTrabajo (CategoriaTrabajo categoriaTrabajo);
}
