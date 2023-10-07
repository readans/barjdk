package org.barjdk.repository;

import org.barjdk.entity.EmpleadoEntity;
import org.barjdk.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("ProductoRepository")

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer>{

}


