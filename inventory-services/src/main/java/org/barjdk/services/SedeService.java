package org.barjdk.services;

import org.barjdk.entity.SedeEntity;

import java.util.List;

public interface SedeService {
    List<SedeEntity> consultarTodos();
    SedeEntity consultarPorId(Integer pkSedeId);
    SedeEntity guardar(SedeEntity sede);
    void eliminar(SedeEntity sede);
    void eliminarPorId(Integer pkSedeId);
}
