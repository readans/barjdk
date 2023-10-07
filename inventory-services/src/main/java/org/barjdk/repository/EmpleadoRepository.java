package org.barjdk.repository;

import org.barjdk.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EmpleadoRepository")

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer>{

}
