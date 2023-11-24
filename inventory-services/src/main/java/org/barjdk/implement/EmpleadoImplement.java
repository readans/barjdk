package org.barjdk.implement;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PermisosEmpleadoEntity;
import org.barjdk.repository.EmpleadoRepository;
import org.barjdk.repository.PermisosEmpleadoRepository;
import org.barjdk.services.EmpleadoService;
import org.barjdk.utils.cipher.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmpleadoImplement implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PermisosEmpleadoRepository permisosEmpleadoRepository;

    @Override
    public EmpleadoEntity consultarPorId(Integer pkEmpleadoId) { return empleadoRepository.findById(pkEmpleadoId).orElse(null); }

    @Override
    public List<EmpleadoEntity> consultarTodos() { return this.empleadoRepository.findAll(); }

    @Override
    public EmpleadoEntity guardar(EmpleadoEntity empleado) {
        empleado.setClaveAcceso(SHA256.getHash(empleado.getClaveAcceso()));
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(EmpleadoEntity empleado) {empleadoRepository.delete(empleado); }

    @Override
    public void eliminarPorId(Integer pkEmpleadoId) { empleadoRepository.deleteById(pkEmpleadoId);}

    @Override
    public PermisosEmpleadoEntity validarAcceso(String usuarioAcceso, String claveAcceso) {return permisosEmpleadoRepository.findByUsuarioAccesoAndClaveAcceso(usuarioAcceso, SHA256.getHash(claveAcceso));}

}
