package com.categoria.service;

import com.categoria.entity.Persona;
import com.categoria.entity.PlataformaDigital;
import com.categoria.enums.CategoriaTrabajo;
import com.categoria.exception.PersonaNotFoundException;
import com.categoria.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona agregarPermiso(Long personaId, PlataformaDigital plataforma) {
        Optional<Persona> optionalPersona = personaRepository.findById(personaId);
        if (optionalPersona.isPresent()) {
            Persona persona = optionalPersona.get();
            persona.getPermisos().add(plataforma);
            return personaRepository.save(persona);
        }
        throw new PersonaNotFoundException("La persona con ID " + personaId + " no existe.");
    }

    public Persona obtenerPersonaPorId(Long personaId) {
        Optional<Persona> optionalPersona = personaRepository.findById(personaId);
        if (optionalPersona.isPresent()) {
            return optionalPersona.get();
        } else {
            throw new PersonaNotFoundException("La persona con ID " + personaId + " no existe.");
        }
    }


    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public List<Persona> obtenerPersonasPorCategoria(CategoriaTrabajo categoria) {
        return personaRepository.findByCategoriaTrabajo(categoria);
    }

    public Set<PlataformaDigital> getPermisos(Long personaId) {
        Persona persona = obtenerPersonaPorId(personaId);
        return persona.getPermisos();
    }

    // Otros métodos de servicio según sea necesario
}
