package org.barjdk.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.MesaEntity;
import org.barjdk.implement.MesaImplement;
import org.barjdk.services.MesaService;
import org.barjdk.utils.cipher.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@CrossOrigin(origins = "*")
@Slf4j
public class MesaController {

    @Autowired
    MesaService mesaService;
    @Autowired
    Jwt jwt;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/consultarTodos")
    public String consultarTodos() throws Exception {
        ObjectNode jsonNode = objectMapper.createObjectNode();
        ArrayNode arrayNode = objectMapper.valueToTree(mesaService.consultarTodos());
        jsonNode.set("mesas", arrayNode);
        return jwt.encrypt(jsonNode.toString());
    }

    @GetMapping("/consultar/{id}")
    public String consultarPorId(@PathVariable(name = "id") Integer pkMesaId) throws Exception {
        return jwt.encrypt(objectMapper.writeValueAsString(mesaService.consultarPorId(pkMesaId)));
    }

    @RequestMapping(path = "/guardar", method = {RequestMethod.POST, RequestMethod.PUT})
    public String guardar(@RequestBody String token) throws Exception {
        MesaEntity mesa = objectMapper.readValue(jwt.decrypt(token), MesaEntity.class);
        return jwt.encrypt(objectMapper.writeValueAsString(mesaService.guardar(mesa)));
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody String token) throws Exception {
        MesaEntity mesa = objectMapper.readValue(jwt.decrypt(token), MesaEntity.class);
        mesaService.eliminar(mesa);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable(name = "id") Integer pkMesaId) {
        mesaService.eliminarPorId(pkMesaId);
    }

}
