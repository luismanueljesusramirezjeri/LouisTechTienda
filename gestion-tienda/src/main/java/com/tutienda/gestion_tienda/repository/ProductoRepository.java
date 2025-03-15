package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
