package com.tutienda.gestion_tienda.repository;

import com.tutienda.gestion_tienda.models.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion,Long>{
        }