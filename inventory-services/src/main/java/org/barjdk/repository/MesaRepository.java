package org.barjdk.repository;

import org.barjdk.entity.MesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("MesaRepository")

public interface MesaRepository extends JpaRepository<MesaEntity, Integer>{
}
