package org.barjdk.services;

import org.barjdk.entity.MesaEntity;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.model.Orden;

import java.util.List;

public interface PedidoService {
    List<PedidoEntity> consultarTodos();
    PedidoEntity consultarPorId(Integer pkPedidoId);
    PedidoEntity guardar(PedidoEntity pedido);
    PedidoEntity crearOrden(Orden orden);

}
