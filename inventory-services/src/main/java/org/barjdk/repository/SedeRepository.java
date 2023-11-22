package org.barjdk.repository;

import org.barjdk.entity.SedeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("SedeRepository")
public interface SedeRepository extends JpaRepository<SedeEntity, Integer> {
}
