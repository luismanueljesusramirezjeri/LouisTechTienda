package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Producto;
import com.tutienda.gestion_tienda.repository.projection.ResumenProductoProjection;
import com.tutienda.gestion_tienda.repository.projection.ResumenUsuarioProjection;
import com.tutienda.gestion_tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return ResponseEntity.ok(productoService.obtenerTodosLosProductos());
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerProductoPorId(id));
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }


    // PUT - Reemplazar todo el producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
    }

    // PATCH - Actualización parcial
    @PatchMapping("/{id}")
    public ResponseEntity<Producto> actualizarParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(productoService.actualizarParcialmenteProducto(id, updates));
    }





    //obtener productos por nombre utilizando la inferzas de proyeccion ResumenProductoProjection
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ResumenProductoProjection>>obtenerProductosPorNombre(@PathVariable String nombre){
        System.out.println("Buscar productos por nombre" + nombre);
        List<ResumenProductoProjection> productos = productoService.obtenerProductosPorNombreProyectado(nombre);
        return ResponseEntity.ok(productos);
    }


    //Actualiza el producto por ID
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualzarProductoPorId(
            @PathVariable("id") Long idProducto,
            @RequestBody Producto producto) { // Recibe el objeto completo en JSON

        productoService.actualizarProducto(
                idProducto,
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );

        return ResponseEntity.ok("Producto actualizado con éxito");
    }



}
