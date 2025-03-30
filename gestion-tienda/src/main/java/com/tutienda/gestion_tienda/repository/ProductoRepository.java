package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Producto;
import com.tutienda.gestion_tienda.repository.projection.ResumenProductoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Consulta JPQL utilizando la interfaz de proyección ResumenUsuarioProjection
    @Query("""
        SELECT p.idProducto AS idProducto,  p.nombre AS nombre, p,descripcion AS descripcion, p.stock AS stock
        FROM Producto p
        WHERE p.nombre LIKE %:nombre%
    """)
    List<ResumenProductoProjection> obtenerProductosPorNombreProyectado(@Param("nombre")String nombre);
}
