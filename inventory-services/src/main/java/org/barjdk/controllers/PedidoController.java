package org.barjdk.controllers;

import org.barjdk.entity.MesaEntity;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.services.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    private final Logger log = LoggerFactory.getLogger(PedidoController.class);

    @PostMapping(path = "/insertar")
    public void insertarPedido(@RequestBody PedidoEntity pedidoEntity) {
        pedidoService.insertarPedido(pedidoEntity);
    }

    @GetMapping("/consultar")
    public List<PedidoEntity> consultarPedidos(){
        return pedidoService.consultarPedidos();
    }
}
