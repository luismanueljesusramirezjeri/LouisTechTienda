package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Proveedor;
import com.tutienda.gestion_tienda.repository.projection.ResumenProductoProjection;
import com.tutienda.gestion_tienda.repository.projection.ResumenProveedorProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    //Nativa JPA
    @Transactional
    @Modifying
    @Query(value = """
    UPDATE proveedores SET
    contacto = :contacto,
    telefono =:telefono,
    email =:email
    WHERE id_proveedor = :idProveedor_
    """, nativeQuery = true)
    void actualizarDatosdelProveedor(
            @Param("contacto") String contacto,
            @Param("telefono") String telefono,
            @Param("email") String email,
            @Param("idProveedor_") Long idProveedor_
    );



}
