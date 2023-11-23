package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.DetallePedidoEntity;
import org.barjdk.entity.PedidoDetallesEntity;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.repository.DetallePedidoRepository;
import org.barjdk.repository.PedidoDetallesRepository;
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
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private PedidoDetallesRepository pedidoDetallesRepository;

    @Override
    public List<PedidoEntity> consultarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntity consultarPorId(Integer pkPedidoId) {
        return pedidoRepository.findById(pkPedidoId).orElse(null);
    }

    @Override
    public PedidoDetallesEntity consultaDetallada(Integer pkPedidoId) {
        return pedidoDetallesRepository.findById(pkPedidoId).orElse(null);
    }

    @Override
    public PedidoEntity guardar(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public PedidoEntity generar(PedidoDetallesEntity pedidoDetalles) {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setFkEmpleadoId(pedidoDetalles.getFkEmpleadoId());
        pedido.setFkMesaId(pedidoDetalles.getFkMesaId());
        PedidoEntity pedidoCreado = pedidoRepository.save(pedido);
        pedidoDetalles.getDetalles().forEach((DetallePedidoEntity detalle) -> {
            detalle.setFkPedidoId(pedidoCreado.getPkPedidoId());
        });
        detallePedidoRepository.saveAll(pedidoDetalles.getDetalles());
        return pedidoCreado;
    }
}
