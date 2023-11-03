package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.PagoEntity;
import org.barjdk.repository.PagoRepository;
import org.barjdk.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PagoImplement implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public void insertarPago(PagoEntity pagoEntity){
        pagoRepository.save(pagoEntity);
    }
}
