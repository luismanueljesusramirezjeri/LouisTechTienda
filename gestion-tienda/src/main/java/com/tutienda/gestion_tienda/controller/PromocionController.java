package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.Promocion;
import com.tutienda.gestion_tienda.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    // Obtener todas las promociones
    @GetMapping
    public ResponseEntity<List<Promocion>> listarPromociones() {
        return ResponseEntity.ok(promocionService.obtenerTodas());
    }

    // Obtener una promoción por ID
    // Obtener una promoción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Promocion> obtenerPromocion(@PathVariable Long id) {
        Promocion promocion = promocionService.obtenerPorId(id);
        return ResponseEntity.ok(promocion);
    }


    // Guardar una nueva promoción
    @PostMapping
    public ResponseEntity<Promocion> crearPromocion(@RequestBody Promocion promocion) {
        return ResponseEntity.ok(promocionService.guardarPromocion(promocion));
    }

    // Eliminar una promoción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPromocion(@PathVariable Long id) {
        promocionService.eliminarPromocion(id);
        return ResponseEntity.noContent().build();
    }
}