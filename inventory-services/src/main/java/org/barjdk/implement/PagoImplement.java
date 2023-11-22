package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.PagoEntity;
import org.barjdk.repository.PagoRepository;
import org.barjdk.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PagoImplement implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<PagoEntity> consultarTodos() {
        return pagoRepository.findAll();
    }

    @Override
    public PagoEntity consultarPorId(Integer pkPagoId) {
        return pagoRepository.findById(pkPagoId).orElse(null);
    }

    @Override
    public PagoEntity guardar(PagoEntity pago) {
        return pagoRepository.save(pago);
    }

}
