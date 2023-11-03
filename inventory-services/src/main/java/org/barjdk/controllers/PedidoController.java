package org.barjdk.controllers;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.implement.PedidoImplement;
import org.barjdk.services.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    PedidoImplement pedidoImplement;

    @Autowired
    PedidoService pedidoService;

    private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

    @PostMapping(path = "/insertar")
    public void insertarPedido(@RequestBody PedidoEntity pedidoEntity) {
        pedidoService.insertarEmpleado(pedidoEntity);
    }

}
