package org.barjdk.service;

import org.barjdk.entity.EmpleadoEntity;
public interface EmpleadoService {

    void insertarEmpleado(EmpleadoEntity empleadoEntity);

    boolean autenticarUsuario(String nombre, Integer documento);

}
