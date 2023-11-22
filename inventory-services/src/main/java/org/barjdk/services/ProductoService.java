package org.barjdk.services;

import org.barjdk.entity.ProductoEntity;
import java.util.List;

public interface ProductoService {
    List<ProductoEntity> consultarTodos();
    ProductoEntity consultarPorId(Integer pkProductoId);
    ProductoEntity guardar(ProductoEntity producto);
    void eliminar(ProductoEntity producto);
    void eliminarPorId(Integer pkProductoId);
}
