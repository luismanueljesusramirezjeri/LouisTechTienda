package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.Producto;
import com.tutienda.gestion_tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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


    // PUT - Actualizar completamente un producto
    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));

        // Se reemplazan todos los datos
        productoExistente.setNombre(nuevoProducto.getNombre());
        productoExistente.setPrecio(nuevoProducto.getPrecio());
        productoExistente.setStock(nuevoProducto.getStock());
        productoExistente.setDescripcion(nuevoProducto.getDescripcion());
        productoExistente.setCategoria(nuevoProducto.getCategoria());
        productoExistente.setFechaCaducidad(nuevoProducto.getFechaCaducidad());

        return productoRepository.save(productoExistente);
    }

    // PATCH - Actualizar parcialmente un producto
    public Producto actualizarParcialmenteProducto(Long id, Map<String, Object> updates) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));

        updates.forEach((campo, valor) -> {
            switch (campo) {
                case "nombre" -> producto.setNombre((String) valor);
                case "precio" -> producto.setPrecio((Double) valor);
                case "stock" -> producto.setStock((Integer) valor);
                case "descripcion" -> producto.setDescripcion((String) valor);
                case "categoria" -> producto.setCategoria((String) valor);
                case "fecha_caducidad" -> producto.setFechaCaducidad((String) valor);
            }
        });

        return productoRepository.save(producto);
    }
}
