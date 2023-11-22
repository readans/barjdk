package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.model.Orden;
import org.barjdk.repository.PedidoRepository;
import org.barjdk.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PedidoImplement implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<PedidoEntity> consultarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntity consultarPorId(Integer pkPedidoId) {
        return pedidoRepository.findById(pkPedidoId).orElse(null);
    }

    @Override
    public PedidoEntity guardar(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public PedidoEntity crearOrden(Orden orden) {

        return null;
    }
}
