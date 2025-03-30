package com.tutienda.gestion_tienda.repository.projection;

import java.time.LocalDateTime;

public interface ResumenDetalleVentaProjection {

    Long getIdDetalle();

    Integer getCantidad();

    Double getPrecioUnitario();

    Double getSubtotal();



    String getNombre();
    LocalDateTime getFecha();




}
