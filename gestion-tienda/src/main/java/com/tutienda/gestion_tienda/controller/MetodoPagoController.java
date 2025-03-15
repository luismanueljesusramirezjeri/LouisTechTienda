package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.MetodoPago;
import com.tutienda.gestion_tienda.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerMetodoPagoPorId(@PathVariable Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoService.obtenerMetodoPagoPorId(id);
        return metodoPago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
}
