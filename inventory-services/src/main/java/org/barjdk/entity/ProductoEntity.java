package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTO")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PRODUCTO_ID")
    private Integer pkProductoId;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "VALOR")
    private Integer valor;

    @Column(name = "CANTIDAD")
    private Integer cantidad;
}


