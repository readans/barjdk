package org.barjdk.services;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PermisosEmpleadoEntity;

import java.util.List;

public interface EmpleadoService {

    EmpleadoEntity consultarPorId(Integer pkEmpleadoId);
    List<EmpleadoEntity> consultarTodos();
    EmpleadoEntity guardar(EmpleadoEntity empleado);
    void eliminar(EmpleadoEntity empleado);
    void eliminarPorId(Integer pkEmpleadoId);
    PermisosEmpleadoEntity validarAcceso(String usuarioAcceso, String claveAcceso);

}
