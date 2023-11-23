package org.barjdk.services;

import org.barjdk.entity.PedidoDetallesEntity;
import org.barjdk.entity.PedidoEntity;

import java.util.List;

public interface PedidoService {
    List<PedidoEntity> consultarTodos();
    PedidoEntity consultarPorId(Integer pkPedidoId);
    PedidoDetallesEntity consultaDetallada(Integer pkPedidoId);
    PedidoEntity guardar(PedidoEntity pedido);
    PedidoEntity generar(PedidoDetallesEntity pedidoDetalles);

}
