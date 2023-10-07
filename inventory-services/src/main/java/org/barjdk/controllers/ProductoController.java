package org.barjdk.controllers;

import org.barjdk.entity.ProductoEntity;
import org.barjdk.implement.ProductoImplement;
import org.barjdk.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    ProductoImplement productoImplement;

    @Autowired
    ProductoService productoService;

    @GetMapping("/consultar")
    public List<ProductoEntity> obtenerTodosProductos(){
        return productoService.obtenerTodosProductos();
    }

}
