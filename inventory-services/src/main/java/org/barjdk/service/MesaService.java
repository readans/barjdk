package org.barjdk.service;

import org.barjdk.entity.MesaEntity;
import org.barjdk.entity.ProductoEntity;
import java.util.List;
public interface MesaService {

    List<MesaEntity> obtenerTodasMesas();

}
