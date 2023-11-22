package org.barjdk.controllers;

import org.barjdk.entity.ProductoEntity;
import org.barjdk.implement.ProductoImplement;
import org.barjdk.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/consultarTodos")
    public List<ProductoEntity> consultarTodos(){
        return productoService.consultarTodos();
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
