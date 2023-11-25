package org.barjdk.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PagoEntity;
import org.barjdk.implement.PagoImplement;
import org.barjdk.services.PagoService;
import org.barjdk.utils.cipher.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    PagoService pagoService;
    @Autowired
    Jwt jwt;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

    @GetMapping(path = "/consultar/{id}")
    public PagoEntity consultarPorId(@PathVariable(name = "id") Integer pkPagoId) { return pagoService.consultarPorId(pkPagoId); }

    @GetMapping(path = "/consultarTodos")
    public String consultarTodos() throws Exception {
        ObjectNode jsonNode = objectMapper.createObjectNode();
        ArrayNode arrayNode = objectMapper.valueToTree(pagoService.consultarTodos());
        jsonNode.set("pagos", arrayNode);
        return jwt.encrypt(jsonNode.toString());
    }

    @RequestMapping(path = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT }, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String guardar(@RequestBody String token) throws Exception {
        PagoEntity pago = objectMapper.readValue(jwt.decrypt(token), PagoEntity.class);
        return jwt.encrypt(objectMapper.writeValueAsString(pagoService.guardar(pago)));
    }

}
