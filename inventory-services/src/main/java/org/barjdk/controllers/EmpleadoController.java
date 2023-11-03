package org.barjdk.controllers;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.implement.EmpleadoImplement;
import org.barjdk.services.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    EmpleadoImplement empleadoImplement;

    @Autowired
    EmpleadoService empleadoService;

    private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

    @PostMapping(path = "/insertar")
    public void insertarEmpleado(@RequestBody EmpleadoEntity empleadoEntity) {
        empleadoService.insertarEmpleado(empleadoEntity);
    }

    @PostMapping(path = "/verificar")
    public ResponseEntity<?> verificarEmpleado(@RequestBody EmpleadoEntity empleadoEntity) {
        EmpleadoEntity empleado = empleadoService.obtenerEmpleado(empleadoEntity.getUsuarioAcceso(), empleadoEntity.getClaveAcceso());

        if (empleado != null) {
            log.info("Empleado encontrado en la base de datos.");
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Empleado encontrado en la base de datos.");
            response.put("perfil", empleado.getFkRolId());
            return ResponseEntity.ok().body(response);
        } else {
            log.warn("El empleado no existe en la base de datos.");
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "El empleado no existe en la base de datos.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }


}
