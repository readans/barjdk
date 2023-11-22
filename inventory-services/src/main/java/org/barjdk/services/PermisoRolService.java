package org.barjdk.services;

import org.barjdk.entity.PermisoRolEntity;
import org.barjdk.entity.RolEntity;

import java.util.List;

public interface PermisoRolService {

    List<PermisoRolEntity> consultarPorRol(RolEntity rolEntity);
}
