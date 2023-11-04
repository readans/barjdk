package org.barjdk.repository;

import org.barjdk.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PedidoRepository")
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

}
