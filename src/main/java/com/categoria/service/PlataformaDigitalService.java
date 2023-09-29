package com.categoria.service;

import com.categoria.entity.PlataformaDigital;
import com.categoria.repository.PlataformaDigitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaDigitalService {
    @Autowired
    private PlataformaDigitalRepository plataformaDigitalRepository;

    public List<PlataformaDigital> obtenerTodasLasPlataformas() {
        return plataformaDigitalRepository.findAll();
    }

    // Otros métodos de servicio según sea necesario
}

