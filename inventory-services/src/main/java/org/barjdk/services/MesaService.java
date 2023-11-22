package org.barjdk.services;

import org.barjdk.entity.MesaEntity;
import org.barjdk.entity.ProductoEntity;

import java.util.List;
public interface MesaService {
    List<MesaEntity> consultarTodos();
    MesaEntity consultarPorId(Integer pkMesaId);
    MesaEntity guardar(MesaEntity mesa);
    void eliminar(MesaEntity mesa);
    void eliminarPorId(Integer pkMesaId);

}
