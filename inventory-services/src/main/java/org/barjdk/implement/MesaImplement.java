package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.MesaEntity;
import org.barjdk.repository.MesaRepository;
import org.barjdk.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MesaImplement implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<MesaEntity> obtenerTodasMesas() {
        return mesaRepository.findAll();
    }
}
