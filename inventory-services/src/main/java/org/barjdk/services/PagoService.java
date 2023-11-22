package org.barjdk.services;

import org.barjdk.entity.MesaEntity;
import org.barjdk.entity.PagoEntity;

import java.util.List;

public interface PagoService {
    List<PagoEntity> consultarTodos();
    PagoEntity consultarPorId(Integer pkPagoId);
    PagoEntity guardar(PagoEntity pago);

}
