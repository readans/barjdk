package org.barjdk.repository;

import org.barjdk.entity.PedidoDetallesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PedidoDetallesRepository")
public interface PedidoDetallesRepository extends JpaRepository<PedidoDetallesEntity, Integer> {
}
