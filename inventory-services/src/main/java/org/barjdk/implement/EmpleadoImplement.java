package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.repository.EmpleadoRepository;
import org.barjdk.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmpleadoImplement implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoImplement(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public void insertarEmpleado(EmpleadoEntity empleadoEntity) {
        empleadoRepository.save(empleadoEntity);
    }

    public EmpleadoEntity obtenerEmpleado(String usuarioAcceso, String claveAcceso) {
        return empleadoRepository.findByUsuarioAccesoAndClaveAcceso(usuarioAcceso, claveAcceso);
    }

}
