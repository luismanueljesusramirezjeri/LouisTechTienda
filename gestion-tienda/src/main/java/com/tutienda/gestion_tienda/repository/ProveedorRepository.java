package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Proveedor;
import com.tutienda.gestion_tienda.repository.projection.ResumenProductoProjection;
import com.tutienda.gestion_tienda.repository.projection.ResumenProveedorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // Con sulta JPQL
    @Query("""
            SELECT p.nombre AS nombre  , p.contacto AS contacto, p.telefono AS telefono
            FROM Proveedor p
            WHERE p.nombre LIKE %:nombre%
            """)
    List<ResumenProveedorProjection> obtenerProveedorPorNombreProyectado(@Param("nombre") String nombre);

}
