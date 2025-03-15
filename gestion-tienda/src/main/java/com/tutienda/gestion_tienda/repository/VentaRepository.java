package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
