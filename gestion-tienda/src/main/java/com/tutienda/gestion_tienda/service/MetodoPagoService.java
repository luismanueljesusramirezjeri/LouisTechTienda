package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.models.MetodoPago;
import com.tutienda.gestion_tienda.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Optional<MetodoPago> obtenerMetodoPagoPorId(Long id) {
        return metodoPagoRepository.findById(id);
    }

    // Guardar un nuevo método de pago
    public MetodoPago guardarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    // Eliminar un método de pago
    public void eliminarMetodoPago(Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
