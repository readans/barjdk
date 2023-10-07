package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTO")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PAGO_ID")
    private Integer pkPagoId;

    @Column(name = "FK_PEDIDO_ID")
    private Integer fkPedidoId;

    @Column(name = "VALOR")
    private Integer valor;
}


