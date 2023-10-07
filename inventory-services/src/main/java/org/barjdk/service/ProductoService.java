package org.barjdk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.ProductoEntity;
import java.util.List;

public interface ProductoService {

    List<ProductoEntity> obtenerTodosProductos();

}
