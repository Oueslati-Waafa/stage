package com.stage.backend.stage.repository;

import com.stage.backend.stage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  StageRepository extends JpaRepository<Stage,Integer> {
    Stage findByName(String name);
}
