package com.stage.backend.stage.security.service;

import com.stage.backend.stage.repository.StageRepository;
import com.stage.backend.stage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StageService {
    @Autowired
    private StageRepository repository;

    public Stage saveStage(Stage stage) {
        return repository.save(stage);
    }

    public List<Stage> saveStages(List<Stage> stages) {
        return repository.saveAll(stages);
    }

    public List<Stage> getStages() {
        return repository.findAll();
    }

    public Stage getStageById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Stage getStageByName(String name) {
        return repository.findByName(name);
    }

    public String deleteStage(int id) {
        repository.deleteById(id);
        return "internship removed !! " + id;
    }

    public Stage updateStage(Stage stage) {
        Stage existingStage = repository.findById(stage.getId()).orElse(null);
        existingStage.setName(stage.getName());
        existingStage.setDescription(stage.getDescription());
        existingStage.setDate_deb(stage.getDate_deb());
        existingStage.setDate_fin(stage.getDate_fin());
        existingStage.setLien_git(stage.getLien_git());
        existingStage.setStatus(stage.getStatus());
        return repository.save(existingStage);
    }


}