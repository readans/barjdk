package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.repository.PedidoRepository;
import org.barjdk.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PedidoImplement implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void insertarEmpleado(PedidoEntity pedidoEntity) {
        pedidoRepository.save(pedidoEntity);
    }
}
