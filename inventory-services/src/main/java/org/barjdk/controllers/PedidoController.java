package org.barjdk.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.barjdk.entity.PedidoDetallesEntity;
import org.barjdk.entity.PedidoEntity;
import org.barjdk.services.PedidoService;
import org.barjdk.utils.cipher.Jwt;
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
    @Autowired
    Jwt jwt;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Logger log = LoggerFactory.getLogger(PedidoController.class);

    @GetMapping("/consultarTodos")
    public String consultarTodos() throws Exception {
        ObjectNode jsonNode = objectMapper.createObjectNode();
        ArrayNode arrayNode = objectMapper.valueToTree(pedidoService.consultarTodos());
        jsonNode.set("pedidos", arrayNode);
        return jwt.encrypt(jsonNode.toString());
    }
    @GetMapping("/consultar/{id}")
    public PedidoEntity consultarPorId(@PathVariable(name = "id") Integer pkPedidoId) {return pedidoService.consultarPorId(pkPedidoId);}
    @GetMapping("/consultaDetallada/{id}")
    public PedidoDetallesEntity consultaDetallada(@PathVariable(name = "id") Integer pkPedidoId) {return pedidoService.consultaDetallada(pkPedidoId);}
    @RequestMapping(path = "/guardar", method = {RequestMethod.POST, RequestMethod.PUT})
    public PedidoEntity guardar(@RequestBody PedidoEntity pedido) {
        return pedidoService.guardar(pedido);
    }
    @PostMapping(path = "/generar")
    public String generar(@RequestBody String token) throws Exception {
        PedidoDetallesEntity pedidoDetalles = objectMapper.readValue(jwt.decrypt(token), PedidoDetallesEntity.class);
        return jwt.encrypt(objectMapper.writeValueAsString(pedidoService.generar(pedidoDetalles)));
    }

}
