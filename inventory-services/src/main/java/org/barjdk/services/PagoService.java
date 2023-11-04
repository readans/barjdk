package org.barjdk.services;

import org.barjdk.entity.PagoEntity;

import java.util.List;

public interface PagoService {

    void insertarPago(PagoEntity pagoEntity);

    List<PagoEntity> consultarPago(Integer pkPagoId);

}
