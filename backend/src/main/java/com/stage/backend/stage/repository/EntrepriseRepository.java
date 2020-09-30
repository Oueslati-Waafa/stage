package com.stage.backend.stage.repository;

import com.stage.backend.stage.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
}
