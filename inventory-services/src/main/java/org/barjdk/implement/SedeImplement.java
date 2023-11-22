package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.SedeEntity;
import org.barjdk.repository.SedeRepository;
import org.barjdk.services.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SedeImplement implements SedeService {

    @Autowired
    SedeRepository sedeRepository;

    @Override
    public List<SedeEntity> consultarTodos() {
        return sedeRepository.findAll();
    }

    @Override
    public SedeEntity consultarPorId(Integer pkSedeId) {
        return sedeRepository.findById(pkSedeId).orElse(null);
    }

    @Override
    public SedeEntity guardar(SedeEntity sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public void eliminar(SedeEntity sede) {
        sedeRepository.delete(sede);
    }

    @Override
    public void eliminarPorId(Integer pkSedeId) {
        sedeRepository.deleteById(pkSedeId);
    }
}
