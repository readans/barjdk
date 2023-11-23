package org.barjdk.controllers;

import org.barjdk.entity.PedidoDetallesEntity;
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

    @GetMapping("/consultarTodos")
    public List<PedidoEntity> consultarTodos() {return pedidoService.consultarTodos();}
    @GetMapping("/consultar/{id}")
    public PedidoEntity consultarPorId(@PathVariable(name = "id") Integer pkPedidoId) {return pedidoService.consultarPorId(pkPedidoId);}
    @GetMapping("/consultaDetallada/{id}")
    public PedidoDetallesEntity consultaDetallada(@PathVariable(name = "id") Integer pkPedidoId) {return pedidoService.consultaDetallada(pkPedidoId);}
    @RequestMapping(path = "/guardar", method = {RequestMethod.POST, RequestMethod.PUT})
    public PedidoEntity guardar(@RequestBody PedidoEntity pedido) {
        return pedidoService.guardar(pedido);
    }
    @PostMapping(path = "/generar")
    public PedidoEntity generar(@RequestBody PedidoDetallesEntity pedidoDetalles) {
        return pedidoService.generar(pedidoDetalles);
    }

}
