package org.barjdk.repository;

import org.barjdk.entity.PermisoRolEntity;
import org.barjdk.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PermisoRolRepository")
public interface PermisoRolRepository extends JpaRepository<PermisoRolEntity, Integer> {

    List<PermisoRolEntity> findByRol(RolEntity Rol);
}
