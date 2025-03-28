package com.tutienda.gestion_tienda.service;

import com.tutienda.gestion_tienda.exception.ResourceNotFoundException;
import com.tutienda.gestion_tienda.models.DetalleVenta;
import com.tutienda.gestion_tienda.models.Venta;
import com.tutienda.gestion_tienda.models.Producto;
import com.tutienda.gestion_tienda.repository.DetalleVentaRepository;
import com.tutienda.gestion_tienda.repository.VentaRepository;
import com.tutienda.gestion_tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los detalles de venta
    public List<DetalleVenta> obtenerTodos() {
        return detalleVentaRepository.findAll();
    }

    // Obtener un detalle de venta por ID
    // Obtener un detalle de venta por ID con validación
    public DetalleVenta obtenerPorId(Long id) {
        return detalleVentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de venta con ID " + id + " no encontrado"));
    }

    // Obtener detalles de una venta específica
    public List<DetalleVenta> obtenerPorVenta(Long idVenta) {
        return detalleVentaRepository.findByVentaIdVenta(idVenta);
    }

    // Guardar un nuevo detalle de venta
    public DetalleVenta guardarDetalle(Long idVenta, Long idProducto, Integer cantidad, Double precioUnitario) {
        Optional<Venta> ventaOpt = ventaRepository.findById(idVenta);
        Optional<Producto> productoOpt = productoRepository.findById(idProducto);

        if (ventaOpt.isPresent() && productoOpt.isPresent()) {
            Venta venta = ventaOpt.get();
            Producto producto = productoOpt.get();

            DetalleVenta detalle = new DetalleVenta(venta, producto, cantidad, precioUnitario);
            return detalleVentaRepository.save(detalle);
        } else {
            throw new RuntimeException("Venta o Producto no encontrados");
        }
    }

    // Eliminar un detalle de venta
    // Eliminar un detalle de venta con validación
    public void eliminarDetalle(Long id) {
        if (!detalleVentaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Detalle de venta con ID " + id + " no encontrado");
        }
        detalleVentaRepository.deleteById(id);
    }
}
