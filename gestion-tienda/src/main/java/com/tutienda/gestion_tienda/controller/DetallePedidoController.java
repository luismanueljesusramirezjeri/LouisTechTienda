package com.tutienda.gestion_tienda.controller;

import com.tutienda.gestion_tienda.models.DetallePedido;
import com.tutienda.gestion_tienda.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    // Obtener todos los detalles de pedido
    @GetMapping
    public ResponseEntity<List<DetallePedido>> listarDetallesPedido() {
        return ResponseEntity.ok(detallePedidoService.obtenerTodos());
    }

    // Obtener un detalle de pedido por ID
    // Obtener detalle de pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> obtenerDetallePedido(@PathVariable Long id) {
        System.out.println("Buscando detalle de pedido con ID: " + id);
        return ResponseEntity.ok(detallePedidoService.obtenerPorId(id));
    }

    // Guardar un nuevo detalle de pedido
    @PostMapping
    public ResponseEntity<DetallePedido> crearDetallePedido(@RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(detallePedidoService.guardarDetallePedido(detallePedido));
    }

    // Eliminar un detalle de pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetallePedido(@PathVariable Long id) {
        detallePedidoService.eliminarDetallePedido(id);
        return ResponseEntity.noContent().build();
    }
}
