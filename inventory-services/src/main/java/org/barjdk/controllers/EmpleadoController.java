package org.barjdk.controllers;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.implement.EmpleadoImplement;
import org.barjdk.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
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
}
