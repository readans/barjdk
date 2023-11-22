package org.barjdk.controllers;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PagoEntity;
import org.barjdk.implement.PagoImplement;
import org.barjdk.services.PagoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/pago")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    PagoService pagoService;

    private final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

    @GetMapping(path = "/consultar/{id}")
    public PagoEntity consultarPorId(@PathVariable(name = "id") Integer pkPagoId) { return pagoService.consultarPorId(pkPagoId); }

    @GetMapping(path = "/consultarTodos")
    public List<PagoEntity> consultarTodos() { return this.pagoService.consultarTodos();}

    @RequestMapping(path = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
    public PagoEntity guardar(@RequestBody PagoEntity pago) {return pagoService.guardar(pago);}


}
