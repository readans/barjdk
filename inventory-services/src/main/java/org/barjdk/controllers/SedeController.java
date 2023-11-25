package org.barjdk.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.barjdk.entity.SedeEntity;
import org.barjdk.services.SedeService;
import org.barjdk.utils.cipher.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sede")
@CrossOrigin(origins = "*")
public class SedeController {

    @Autowired
    SedeService sedeService;
    @Autowired
    Jwt jwt;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/consultarTodos")
    public String consultarTodos(){
        ObjectNode jsonNode = objectMapper.createObjectNode();
        ArrayNode productosArrayNode = objectMapper.valueToTree(sedeService.consultarTodos());
        jsonNode.set("sedes", productosArrayNode);
        return jwt.encrypt(jsonNode.toString());
    }

    @GetMapping("/consultar/{id}")
    public SedeEntity consultarPorId(@PathVariable(name = "id") Integer pkSedeId) {
        return sedeService.consultarPorId(pkSedeId);
    }

    @RequestMapping(path = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
    public SedeEntity guardar(@RequestBody SedeEntity sede) {
        return sedeService.guardar(sede);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody SedeEntity sede) {
        sedeService.eliminar(sede);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable(name = "id") Integer pkSedeId) {
        sedeService.eliminarPorId(pkSedeId);
    }

}
