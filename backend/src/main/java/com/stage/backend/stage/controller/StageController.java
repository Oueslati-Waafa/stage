package com.stage.backend.stage.controller;

import com.stage.backend.stage.model.Stage;
import com.stage.backend.stage.security.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StageController {

    @Autowired
    private StageService service;

    @PostMapping("/stage/addStage")
    public Stage addStage(@RequestBody Stage stage) {
        return service.saveStage(stage);
    }

    @PostMapping("/stage/addStages")
    public List<Stage> addStages(@RequestBody List<Stage> stages) {
        return service.saveStages(stages);
    }

    @GetMapping("/stage/Stages")
    public List<Stage> findAllStages() {
        return service.getStages();
    }

    @GetMapping("/stage/stageById/{id}")
    public Stage findStageById(@PathVariable int id) {
        return service.getStageById(id);
    }

    @GetMapping("/stage/stage/{name}")
    public Stage findStageByName(@PathVariable String name) {
        return service.getStageByName(name);
    }

    @PutMapping("/stage/update")
    public Stage updateStage(@RequestBody Stage stage) {
        return service.updateStage(stage);
    }

    @DeleteMapping("/stage/delete/{id}")
    public String deleteStage(@PathVariable int id) {
        return service.deleteStage(id);
    }


}