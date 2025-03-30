package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.DetalleVenta;
import com.tutienda.gestion_tienda.repository.projection.ResumenDetalleVentaProjection;
import com.tutienda.gestion_tienda.repository.projection.ResumenInventarioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findByVentaIdVenta(Long idVenta);

    //Consu  JPQL de 3 relaciones
    @Query("""
            SELECT d.idDetalle AS idDetalle,
                   d.cantidad AS cantidad,
                   d.precioUnitario AS precioUnitario,
                   d.subtotal AS subtotal,
                   p.nombre AS nombre,
                   v.fecha AS fecha
            FROM DetalleVenta d
            JOIN d.producto p
            JOIN d.venta v
            WHERE p.nombre LIKE %:nombre%
            """)
    List<ResumenDetalleVentaProjection> obtenerDetalleVentaPorNombreDelProducto(@Param("nombre")String nombre);


}
