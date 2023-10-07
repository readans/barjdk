package org.barjdk.service;

import org.barjdk.entity.EmpleadoEntity;
public interface EmpleadoService {

    void insertarEmpleado(EmpleadoEntity empleadoEntity);

    public EmpleadoEntity obtenerEmpleado(String nombre, Integer documento);


}
