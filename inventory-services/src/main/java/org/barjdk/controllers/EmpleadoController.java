package org.barjdk.controllers;

import jakarta.websocket.server.PathParam;
import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PermisosEmpleadoEntity;
import org.barjdk.implement.EmpleadoImplement;
import org.barjdk.model.Login;
import org.barjdk.services.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

    @GetMapping(path = "/consultar/{id}")
    public EmpleadoEntity consultarPorId(@PathVariable(name = "id") Integer pkEmpleadoId) { return empleadoService.consultarPorId(pkEmpleadoId); }

    @GetMapping(path = "/consultarTodos")
    public List<EmpleadoEntity> consultarTodos() { return this.empleadoService.consultarTodos();}

    @RequestMapping(path = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
    public EmpleadoEntity guardar(@RequestBody EmpleadoEntity empleadoEntity) {return empleadoService.guardar(empleadoEntity);}

    @DeleteMapping(path = "/eliminar")
    public void eliminar(@RequestBody EmpleadoEntity empleado) { empleadoService.eliminar(empleado); }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable(name = "id") Integer pkEmpleadoId) {
        empleadoService.eliminarPorId(pkEmpleadoId);
    }

    @PostMapping(path = "/validar")
    public PermisosEmpleadoEntity validar(@RequestBody Login login) {
        log.info(String.format("empleado: %s", login.toString()));
        return empleadoService.validarAcceso(login.getUsuarioAcceso(), login.getClaveAcceso());
    }


}