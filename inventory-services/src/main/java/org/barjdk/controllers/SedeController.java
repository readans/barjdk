package org.barjdk.controllers;

import org.barjdk.entity.SedeEntity;
import org.barjdk.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sede")
@CrossOrigin(origins = "*")
public class SedeController {

    @Autowired
    SedeService sedeService;

    @GetMapping("/consultarTodos")
    public List<SedeEntity> consultarTodos(){
        return sedeService.consultarTodos();
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
