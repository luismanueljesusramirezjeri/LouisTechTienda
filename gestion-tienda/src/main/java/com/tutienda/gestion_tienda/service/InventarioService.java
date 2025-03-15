package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.models.Inventario;
import com.tutienda.gestion_tienda.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    // Obtener todos los registros de inventario
    public List<Inventario> obtenerTodosLosInventarios() {
        return inventarioRepository.findAll();
    }

    // Obtener un inventario por ID
    public Optional<Inventario> obtenerInventarioPorId(Long id) {
        return inventarioRepository.findById(id);
    }

    // Guardar un nuevo registro de inventario
    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    // Eliminar un inventario
    public void eliminarInventario(Long id) {
        inventarioRepository.deleteById(id);
    }
}
