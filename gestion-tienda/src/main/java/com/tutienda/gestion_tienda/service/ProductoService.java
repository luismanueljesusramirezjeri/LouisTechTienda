package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.Producto;
import com.tutienda.gestion_tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
    }

    // Guardar un nuevo producto
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar un producto
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto con ID " + id + " no encontrado");
        }
        productoRepository.deleteById(id);
    }
}
