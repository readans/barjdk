package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.MesaEntity;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.repository.PedidoRepository;
import org.barjdk.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PedidoImplement implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void insertarPedido(PedidoEntity pedidoEntity) {
        pedidoRepository.save(pedidoEntity);
    }

    public List<PedidoEntity> consultarPedidos() {
        return pedidoRepository.findAll();
    }

}
