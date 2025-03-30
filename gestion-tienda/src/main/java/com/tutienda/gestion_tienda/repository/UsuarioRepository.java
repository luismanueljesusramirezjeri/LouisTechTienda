package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Usuario;
import com.tutienda.gestion_tienda.repository.projection.ResumenUsuarioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta JPQL utilizando la interfaz de proyección ResumenUsuarioProjection
    @Query("""
        SELECT u.idUsuario AS idUsuario, u.nombre AS nombre, u.rol AS rol, u.contraseña AS contraseña 
        FROM Usuario u
        WHERE u.nombre LIKE %:nombre%
    """)
    List<ResumenUsuarioProjection> obtenerUsuariosPorNombreProyectado(@Param("nombre") String nombre);
}
