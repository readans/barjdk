package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.MesaEntity;
import org.barjdk.repository.MesaRepository;
import org.barjdk.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MesaImplement implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public List<MesaEntity> consultarTodos() {
        return mesaRepository.findAll();
    }

    @Override
    public MesaEntity consultarPorId(Integer pkMesaId) {
        return mesaRepository.findById(pkMesaId).orElse(null);
    }

    @Override
    public MesaEntity guardar(MesaEntity mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public void eliminar(MesaEntity mesa) {
        mesaRepository.delete(mesa);
    }

    @Override
    public void eliminarPorId(Integer pkMesaId) {
        mesaRepository.deleteById(pkMesaId);
    }
}
