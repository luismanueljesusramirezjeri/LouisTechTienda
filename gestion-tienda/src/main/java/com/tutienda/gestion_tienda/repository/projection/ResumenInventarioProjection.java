package com.tutienda.gestion_tienda.repository.projection;

public interface ResumenInventarioProjection {

    Long getIdInventario();

    String getNombre();

    String getUbicacion();

    Integer getStockActual();
}
