package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.DetallePedido;
import com.tutienda.gestion_tienda.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    // Obtener todos los detalles de pedido
    public List<DetallePedido> obtenerTodos() {
        return detallePedidoRepository.findAll();
    }

    // Obtener un detalle de pedido por ID con validación de excepción
    public DetallePedido obtenerPorId(Long id) {
        return detallePedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de pedido con ID " + id + " no encontrado"));
    }
    // Guardar un nuevo detalle de pedido
    public DetallePedido guardarDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    // Eliminar un detalle de pedido con validación
    public void eliminarDetallePedido(Long id) {
        if (!detallePedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Detalle de pedido con ID " + id + " no encontrado");
        }
        detallePedidoRepository.deleteById(id);
    }
}
