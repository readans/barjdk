package org.barjdk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PEDIDO")
public class PedidoDetallesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PEDIDO_ID")
    private Integer pkPedidoId;

    @Column(name = "FK_EMPLEADO_ID")
    private Integer fkEmpleadoId;

    @Column(name = "FK_MESA_ID")
    private Integer fkMesaId;

    @OneToMany(mappedBy = "fkPedidoId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<DetallePedidoEntity> detalles;
}
