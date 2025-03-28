package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Venta;
import com.tutienda.gestion_tienda.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Obtener todas las ventas
    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    // Obtener una venta por ID
// Obtener una venta por ID con manejo de excepciones
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long id) {
        System.out.println("Buscando venta con ID: " + id);
        return ResponseEntity.ok(ventaService.obtenerVentaPorId(id));
    }


    // Crear una nueva venta
    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    // Eliminar una venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }
}
