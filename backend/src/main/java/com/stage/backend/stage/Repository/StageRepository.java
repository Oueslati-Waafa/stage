package com.stage.backend.stage.Repository;

import com.stage.backend.stage.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  StageRepository extends JpaRepository<Stage,Integer> {
    Stage findByName(String name);
}
