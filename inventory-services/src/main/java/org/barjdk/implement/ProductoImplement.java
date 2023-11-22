package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.ProductoEntity;
import org.barjdk.repository.ProductoRepository;
import org.barjdk.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ProductoImplement implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> consultarTodos(){
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity consultarPorId(Integer pkProductoId) {
        return productoRepository.findById(pkProductoId).orElse(null);
    }

    @Override
    public ProductoEntity guardar(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminar(ProductoEntity producto) {
        productoRepository.delete(producto);
    }

    @Override
    public void eliminarPorId(Integer pkProductoId) {
        productoRepository.deleteById(pkProductoId);
    }

}
