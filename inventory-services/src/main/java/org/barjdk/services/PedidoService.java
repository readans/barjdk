package org.barjdk.services;

import org.barjdk.entity.PedidoEntity;
import java.util.List;

public interface PedidoService {

    void insertarPedido(PedidoEntity pedidoEntity);

    List<PedidoEntity> consultarPedidos(Integer pkPedidoId);

}
