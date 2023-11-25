package org.barjdk.controllers;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.ProductoEntity;
import org.barjdk.implement.ProductoImplement;
import org.barjdk.services.ProductoService;
import org.barjdk.utils.cipher.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
@Slf4j
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @Autowired
    Jwt jwt;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/consultarTodos")
    public String consultarTodos() throws Exception {
        ObjectNode jsonNode = objectMapper.createObjectNode();
        ArrayNode productosArrayNode = objectMapper.valueToTree(productoService.consultarTodos());
        jsonNode.set("productos", productosArrayNode);
        return jwt.encrypt(jsonNode.toString());
    }

    @GetMapping("/consultar/{id}")
    public ProductoEntity consultarPorId(@PathVariable(name = "id") Integer pkProductoId) {
        return productoService.consultarPorId(pkProductoId);
    }

    @RequestMapping(path = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
    public ProductoEntity guardar(@RequestBody ProductoEntity producto) {
        return productoService.guardar(producto);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody ProductoEntity producto) {
        productoService.eliminar(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable(name = "id") Integer pkProductoId) {
        productoService.eliminarPorId(pkProductoId);
    }

}
