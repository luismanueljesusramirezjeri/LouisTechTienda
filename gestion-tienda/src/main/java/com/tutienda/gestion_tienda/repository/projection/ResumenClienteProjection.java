package com.tutienda.gestion_tienda.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ResumenClienteProjection {


    Long getIdCliente();

    String getNombre();

    String getEmail();
}
