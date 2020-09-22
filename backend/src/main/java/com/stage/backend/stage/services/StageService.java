package com.stage.backend.stage.services;

import com.stage.backend.stage.Repository.StageRepository;
import com.stage.backend.stage.entity.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StageService {
    @Autowired
    private StageRepository repository;

    public Stage saveStage(Stage product) {
        return repository.save(product);
    }

    public List<Stage> saveStages(List<Stage> products) {
        return repository.saveAll(products);
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