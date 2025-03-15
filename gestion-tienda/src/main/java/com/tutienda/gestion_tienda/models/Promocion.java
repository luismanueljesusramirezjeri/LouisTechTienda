package com.tutienda.gestion_tienda.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "promociones")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocion;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private double descuento;
    private String fechaInicio;
    private String fechaFin;
}
