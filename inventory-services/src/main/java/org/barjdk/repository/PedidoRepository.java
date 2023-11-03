package org.barjdk.repository;

import org.barjdk.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PedidoRepository")
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    List<PedidoEntity> findByPkPedidoId(Integer pkPedidoId);

}
