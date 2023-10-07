package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.ProductoEntity;
import org.barjdk.repository.EmpleadoRepository;
import org.barjdk.repository.ProductoRepository;
import org.barjdk.service.EmpleadoService;
import org.barjdk.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductoImplement implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoEntity> obtenerTodosProductos(){
        return productoRepository.findAll();

    }

}
