package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.Venta;
import com.tutienda.gestion_tienda.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Obtener todas las ventas
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    // Obtener una venta por ID con manejo de excepción
    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venta con ID " + id + " no encontrado"));
    }

    // Guardar una nueva venta
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Eliminar una venta con manejo de excepción
    public void eliminarVenta(Long id) {
        if (!ventaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Venta con ID " + id + " no encontrado");
        }
        ventaRepository.deleteById(id);
    }
}
