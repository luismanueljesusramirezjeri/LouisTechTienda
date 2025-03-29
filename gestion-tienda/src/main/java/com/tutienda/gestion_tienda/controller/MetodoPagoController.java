package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.MetodoPago;
import com.tutienda.gestion_tienda.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/metodos_pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    // Obtener todos los métodos de pago
    @GetMapping
    public List<MetodoPago> obtenerMetodosPago() {
        return metodoPagoService.obtenerTodosLosMetodosPago();
    }

    // Obtener un método de pago por ID
    // Obtener un método de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerMetodoPagoPorId(@PathVariable Long id) {
        MetodoPago metodoPago = metodoPagoService.obtenerMetodoPagoPorId(id);
        return ResponseEntity.ok(metodoPago);
    }


    // Crear un nuevo método de pago
    @PostMapping
    public MetodoPago crearMetodoPago(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.guardarMetodoPago(metodoPago);
    }

    // Eliminar un método de pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMetodoPago(@PathVariable Long id) {
        metodoPagoService.eliminarMetodoPago(id);
        return ResponseEntity.noContent().build();
    }


    // PUT - Reemplazar todos los datos de un método de pago
    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizarMetodoPago(
            @PathVariable Long id,
            @RequestBody MetodoPago metodoPago) {
        return ResponseEntity.ok(metodoPagoService.actualizarMetodoPago(id, metodoPago));
    }

    // PATCH - Actualización parcial de un método de pago
    @PatchMapping("/{id}")
    public ResponseEntity<MetodoPago> actualizarParcialmenteMetodoPago(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(metodoPagoService.actualizarParcialmenteMetodoPago(id, updates));
    }
}
