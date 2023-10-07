package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PEDIDO")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PEDIDO_ID")
    private Integer pkPedidoId;

    @Column(name = "FK_EMPLEADO_ID")
    private Integer fkEmpleadoId;

    @Column(name = "FK_MESA_ID")
    private Integer fkMesaId;
}


