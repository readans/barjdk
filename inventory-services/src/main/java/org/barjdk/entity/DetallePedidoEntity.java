package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DETALLE_PEDIDO")
public class DetallePedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_DETALLE_PEDIDO_ID ")
    private Integer pkDetallePedidoId;

    @Column(name = "FK_PEDIDO_ID")
    private Integer fkPedidoId;

    @Column(name = "FK_PRODUCTO_ID")
    private Integer fkProductoId;

    @Column(name = "CANTIDAD")
    private Integer cantidad;
}
