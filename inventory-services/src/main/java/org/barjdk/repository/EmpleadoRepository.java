package org.barjdk.repository;

import org.barjdk.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("EmpleadoRepository")

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer>{

}
