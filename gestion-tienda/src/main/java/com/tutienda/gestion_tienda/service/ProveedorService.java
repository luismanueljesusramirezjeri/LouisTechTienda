package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.models.Proveedor;
import com.tutienda.gestion_tienda.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Obtener todos los proveedores
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    // Obtener un proveedor por ID
    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    // Guardar un nuevo proveedor
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Eliminar un proveedor
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
