package org.barjdk.repository;

import org.barjdk.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {

    List<PagoEntity> findByPkPagoId(Integer pkPagoId);

}
