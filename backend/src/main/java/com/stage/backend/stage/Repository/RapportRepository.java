package com.stage.backend.stage.Repository;

import com.stage.backend.stage.entity.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport,Integer> {
}
