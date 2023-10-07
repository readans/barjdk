package org.barjdk.controllers;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.ProductoEntity;
import org.barjdk.implement.EmpleadoImplement;
import org.barjdk.implement.ProductoImplement;
import org.barjdk.service.EmpleadoService;
import org.barjdk.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")

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
