package org.barjdk.services;

import org.barjdk.entity.EmpleadoEntity;
public interface EmpleadoService {

    void insertarEmpleado(EmpleadoEntity empleadoEntity);

    public EmpleadoEntity obtenerEmpleado(String usuarioAcceso, String claveAcceso);


}
