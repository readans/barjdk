package org.barjdk.repository;

import org.barjdk.entity.DetallePedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DetallePedidoRepository")
public interface DetallePedidoRepository extends JpaRepository<DetallePedidoEntity, Integer> {
}
