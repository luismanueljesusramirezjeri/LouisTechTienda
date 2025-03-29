package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Cliente;
import com.tutienda.gestion_tienda.repository.projection.ResumenClienteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Consulta JPQL utilizando la interfaz de proyección ResumenClienteProjection
    @Query("""
        SELECT c.idCliente AS idCliente, c.nombre AS nombre, c.email AS email
        FROM Cliente c
        WHERE c.nombre LIKE %:nombre%
    """)
    List<ResumenClienteProjection> obtenerClientesPorNombreProyectado(@Param("nombre") String nombre);
}
