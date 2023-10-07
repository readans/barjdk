package org.barjdk.service;

import org.barjdk.entity.ProductoEntity;
import java.util.List;

public interface ProductoService {

    List<ProductoEntity> obtenerTodosProductos();

}
