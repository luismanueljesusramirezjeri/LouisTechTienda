package com.tutienda.gestion_tienda.models;

import jakarta.persistence.*;

@Entity
@Table(name = "metodos_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long idPago;

    @Column(name = "tipo_pago", nullable = false, unique = true)
    private String tipoPago;

    // Constructor vacío (obligatorio para JPA)
    public MetodoPago() {
    }

    // Constructor con parámetros
    public MetodoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    // Getters y Setters
    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
}
