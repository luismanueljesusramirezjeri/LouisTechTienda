package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Proveedor;
import com.tutienda.gestion_tienda.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Obtener todos los proveedores
    @GetMapping
    public List<Proveedor> obtenerProveedores() {
        return proveedorService.obtenerTodosLosProveedores();
    }

    // Obtener un proveedor por ID
    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        return ResponseEntity.ok(proveedor);
    }

    // Crear un nuevo proveedor
    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.guardarProveedor(proveedor);
    }

    // Eliminar un proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }


    // PUT - Reemplazar todos los datos del proveedor
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(
            @PathVariable Long id,
            @RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.actualizarProveedor(id, proveedor));
    }

    // PATCH - Actualización parcial del proveedor
    @PatchMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(proveedorService.actualizarParcialmenteProveedor(id, updates));
    }
}
