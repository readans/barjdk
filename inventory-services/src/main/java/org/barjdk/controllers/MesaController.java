package org.barjdk.controllers;

import org.barjdk.entity.MesaEntity;
import org.barjdk.implement.MesaImplement;
import org.barjdk.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@CrossOrigin(origins = "*")
public class MesaController {

    @Autowired
    MesaImplement mesaImplement;

    @Autowired
    MesaService mesaService;

    @GetMapping("/consultar")
    public List<MesaEntity> obtenerTodasMesas() {
        return mesaService.obtenerTodasMesas();
    }

}
