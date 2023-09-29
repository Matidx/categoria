package com.categoria.controller;

import com.categoria.entity.Persona;
import com.categoria.entity.PlataformaDigital;
import com.categoria.enums.CategoriaTrabajo;
import com.categoria.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public ResponseEntity<List<Persona>> obtenerTodasLasPersonas() {
        List<Persona> personas = personaService.obtenerTodasLasPersonas();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        Persona persona = personaService.obtenerPersonaPorId(id);
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/por-categoria")
    public ResponseEntity<List<Persona>> obtenerPersonasPorCategoria(@RequestParam CategoriaTrabajo categoria) {
        List<Persona> personas = personaService.obtenerPersonasPorCategoria(categoria);
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}/permisos")
    public ResponseEntity<Set<PlataformaDigital>> getPermisos(@PathVariable Long id) {
        Set<PlataformaDigital> permisos = personaService.getPermisos(id);
        return ResponseEntity.ok(permisos);
    }

    @PostMapping("/{id}/agregar-permiso")
    public ResponseEntity<Persona> agregarPermiso(@PathVariable Long id, @RequestBody PlataformaDigital plataforma) {
        Persona persona = personaService.agregarPermiso(id, plataforma);
        return ResponseEntity.ok(persona);
    }

    // Otros métodos del controlador según sea necesario
}


