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
    MesaService mesaService;

    @GetMapping("/consultarTodos")
    public List<MesaEntity> consultarTodos() {return mesaService.consultarTodos();}

    @GetMapping("/consultar/{id}")
    public MesaEntity consultarPorId(@PathVariable(name = "id") Integer pkMesaId) {return mesaService.consultarPorId(pkMesaId);}

    @RequestMapping(path = "/guardar", method = {RequestMethod.POST, RequestMethod.PUT})
    public MesaEntity guardar(@RequestBody MesaEntity mesa) {
        return mesaService.guardar(mesa);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody MesaEntity mesa) {
        mesaService.eliminar(mesa);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable(name = "id") Integer pkMesaId) {
        mesaService.eliminarPorId(pkMesaId);
    }

}
