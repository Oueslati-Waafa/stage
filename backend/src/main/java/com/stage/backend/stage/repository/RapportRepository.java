package com.stage.backend.stage.repository;

import com.stage.backend.stage.model.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport,Integer> {
}
