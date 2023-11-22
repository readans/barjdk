package org.barjdk.repository;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.PermisosEmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PermisosEmpleadoRepository")
public interface PermisosEmpleadoRepository extends JpaRepository<PermisosEmpleadoEntity, Integer> {

    PermisosEmpleadoEntity findByUsuarioAccesoAndClaveAcceso(String usuarioAcceso, String claveAcceso);
}
