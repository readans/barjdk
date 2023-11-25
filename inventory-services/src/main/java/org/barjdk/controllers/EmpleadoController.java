package org.barjdk.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PermisosEmpleadoEntity;
import org.barjdk.services.EmpleadoService;
import org.barjdk.utils.cipher.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    Jwt jwt;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

    @GetMapping(path = "/consultar/{id}")
    public EmpleadoEntity consultarPorId(@PathVariable(name = "id") Integer pkEmpleadoId) { return empleadoService.consultarPorId(pkEmpleadoId); }

    @GetMapping(path = "/consultarTodos")
    public String consultarTodos() {
        ObjectNode jsonNode = objectMapper.createObjectNode();
        ArrayNode arrayNode = objectMapper.valueToTree(empleadoService.consultarTodos());
        jsonNode.set("empleados", arrayNode);
        return jwt.encrypt(jsonNode.toString());
    }

    @RequestMapping(path = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
    public String guardar(@RequestBody String reqBody) throws Exception {
        String decrypted = jwt.decrypt(reqBody);
        EmpleadoEntity empleadoEntity = objectMapper.readValue(decrypted, EmpleadoEntity.class);
        return jwt.encrypt(objectMapper.writeValueAsString(empleadoService.guardar(empleadoEntity)));
    }

    @DeleteMapping(path = "/eliminar")
    public void eliminar(@RequestBody EmpleadoEntity empleado) { empleadoService.eliminar(empleado); }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable(name = "id") Integer pkEmpleadoId) {
        empleadoService.eliminarPorId(pkEmpleadoId);
    }

    @PostMapping(path = "/validar")
    public String validar(@RequestBody String reqBody) throws Exception {
        String decrypt = jwt.decrypt(reqBody);
        EmpleadoEntity empleado = objectMapper.readValue(decrypt, EmpleadoEntity.class);
        return jwt.encrypt(objectMapper.writeValueAsString(empleadoService.validarAcceso(empleado.getUsuarioAcceso(), empleado.getClaveAcceso())));
    }


}