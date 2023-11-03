package org.barjdk.controllers;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PagoEntity;
import org.barjdk.implement.PagoImplement;
import org.barjdk.service.PagoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    PagoImplement pagoImplement;

    @Autowired
    PagoService pagoService;

    private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

    @PostMapping(path = "/insertar")
    public void insertarPago(@RequestBody PagoEntity pagoEntity) {
        pagoService.insertarPago(pagoEntity);
    }

}
