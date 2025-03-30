package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Producto;
import com.tutienda.gestion_tienda.repository.projection.ResumenProductoProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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




    // Consulta Nativa SQL para actualizar el producto
    @Transactional
    @Modifying
    @Query(value = """
    UPDATE productos SET
    nombre = :nombre,
    precio = :precio,
    stock = :stock
    WHERE id_producto = :idProducto
    """, nativeQuery = true)
    void actualizarPrecioStockProducto(
            @Param("nombre") String nombre,
            @Param("precio") Double precio,
            @Param("stock") Integer stock,
            @Param("idProducto") Long idProducto);

}
