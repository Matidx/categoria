package com.categoria.controller;

import com.categoria.entity.PlataformaDigital;
import com.categoria.service.PlataformaDigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plataformas")
public class PlataformaDigitalController {
    @Autowired
    private PlataformaDigitalService plataformaDigitalService;

    @GetMapping("/")
    public ResponseEntity<List<PlataformaDigital>> obtenerTodasLasPlataformas() {
        List<PlataformaDigital> plataformas = plataformaDigitalService.obtenerTodasLasPlataformas();
        return ResponseEntity.ok(plataformas);
    }

    // Otros métodos del controlador según sea necesario
}