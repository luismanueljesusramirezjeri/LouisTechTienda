package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Inventario;
import com.tutienda.gestion_tienda.repository.projection.ResumenInventarioProjection;
import com.tutienda.gestion_tienda.repository.projection.ResumenProveedorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {


    // Consul   JPQL  de varias tablas
    @Query("""
            SELECT i.idInventario AS idInventario,
                   p.nombre AS nombre,
                   i.ubicacion AS ubicacion,
                   i.stockActual AS stockActual
            FROM Inventario i
            JOIN i.producto p
            WHERE p.nombre LIKE %:nombre%
            """)
    List<ResumenInventarioProjection> obtenerInventarioPorNombreProducto(@Param("nombre") String nombre);

}
