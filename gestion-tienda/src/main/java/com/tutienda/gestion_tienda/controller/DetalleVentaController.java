package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.DetalleVenta;
import com.tutienda.gestion_tienda.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-ventas")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    // Obtener todos los detalles de ventas
    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listarDetalles() {
        return ResponseEntity.ok(detalleVentaService.obtenerTodos());
    }

    // Obtener detalle de venta por ID
    // Obtener detalle de venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> obtenerDetalle(@PathVariable Long id) {
        DetalleVenta detalleVenta = detalleVentaService.obtenerPorId(id);
        return ResponseEntity.ok(detalleVenta);
    }


    // Obtener detalles por venta
    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<DetalleVenta>> obtenerDetallesPorVenta(@PathVariable Long idVenta) {
        return ResponseEntity.ok(detalleVentaService.obtenerPorVenta(idVenta));
    }

    // Guardar un detalle de venta
    @PostMapping
    public ResponseEntity<DetalleVenta> crearDetalle(@RequestParam Long idVenta,
                                                     @RequestParam Long idProducto,
                                                     @RequestParam Integer cantidad,
                                                     @RequestParam Double precioUnitario) {
        return ResponseEntity.ok(detalleVentaService.guardarDetalle(idVenta, idProducto, cantidad, precioUnitario));
    }

    // Eliminar un detalle de venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long id) {
        detalleVentaService.eliminarDetalle(id);
        return ResponseEntity.noContent().build();
    }
}
