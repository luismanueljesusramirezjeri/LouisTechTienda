package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.MetodoPago;
import com.tutienda.gestion_tienda.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    // Obtener todos los métodos de pago
    public List<MetodoPago> obtenerTodosLosMetodosPago() {
        return metodoPagoRepository.findAll();
    }

    // Obtener un método de pago por ID
    // Obtener un método de pago por ID con validación
    public MetodoPago obtenerMetodoPagoPorId(Long id) {
        return metodoPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago con ID " + id + " no encontrado"));
    }
    // Guardar un nuevo método de pago
    public MetodoPago guardarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    // Eliminar un método de pago
    // Eliminar un método de pago con validación
    public void eliminarMetodoPago(Long id) {
        if (!metodoPagoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Método de pago con ID " + id + " no encontrado");
        }
        metodoPagoRepository.deleteById(id);
    }




    // PUT - Reemplazar completamente un método de pago
    public MetodoPago actualizarMetodoPago(Long id, MetodoPago nuevoMetodoPago) {
        MetodoPago metodoExistente = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago con ID " + id + " no encontrado"));

        metodoExistente.setTipoPago(nuevoMetodoPago.getTipoPago());

        return metodoPagoRepository.save(metodoExistente);
    }

    // PATCH - Actualizar parcialmente un método de pago
    public MetodoPago actualizarParcialmenteMetodoPago(Long id, Map<String, Object> updates) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago con ID " + id + " no encontrado"));

        updates.forEach((campo, valor) -> {
            if ("tipoPago".equals(campo)) {
                metodoPago.setTipoPago((String) valor);
            }
        });

        return metodoPagoRepository.save(metodoPago);
    }
}
