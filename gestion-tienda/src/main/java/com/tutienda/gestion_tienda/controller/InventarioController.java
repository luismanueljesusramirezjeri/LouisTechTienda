package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Inventario;
import com.tutienda.gestion_tienda.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Obtener todo el inventario
    @GetMapping
    public List<Inventario> obtenerInventario() {
        return inventarioService.obtenerTodosLosInventarios();
    }

    // Obtener inventario por ID
    // Obtener inventario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerInventarioPorId(@PathVariable Long id) {
        Inventario inventario = inventarioService.obtenerInventarioPorId(id);
        return ResponseEntity.ok(inventario);
    }


    // Crear un nuevo registro en el inventario
    @PostMapping
    public Inventario crearInventario(@RequestBody Inventario inventario) {
        return inventarioService.guardarInventario(inventario);
    }

    // Eliminar un inventario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable Long id) {
        inventarioService.eliminarInventario(id);
        return ResponseEntity.noContent().build();
    }
}
