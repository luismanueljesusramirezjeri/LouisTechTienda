package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.models.Promocion;
import com.tutienda.gestion_tienda.repository.PromocionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    // Obtener todas las promociones
    public List<Promocion> obtenerTodas() {
        return promocionRepository.findAll();
    }

    // Obtener una promoción por ID
    public Optional<Promocion> obtenerPorId(Long id) {
        return promocionRepository.findById(id);
    }

    // Guardar una nueva promoción
    public Promocion guardarPromocion(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    // Eliminar una promoción
    public void eliminarPromocion(Long id) {
        promocionRepository.deleteById(id);
    }
}