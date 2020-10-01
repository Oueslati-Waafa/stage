package com.stage.backend.stage.controller;

import com.stage.backend.stage.model.Stage;
import com.stage.backend.stage.security.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StageController {

    @Autowired
    private StageService service;

    @PostMapping("/stage/addStage")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Stage addStage(@RequestBody Stage stage) {
        return service.saveStage(stage);
    }

    @PostMapping("/stage/addStages")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') ")
    public List<Stage> addStages(@RequestBody List<Stage> stages) {
        return service.saveStages(stages);
    }

    @GetMapping("/stage/Stages")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public List<Stage> findAllStages() {
        return service.getStages();
    }

    @GetMapping("/stage/stageById/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Stage findStageById(@PathVariable int id) {
        return service.getStageById(id);
    }

    @GetMapping("/stage/stage/{name}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Stage findStageByName(@PathVariable String name) {
        return service.getStageByName(name);
    }

    @PutMapping("/stage/update")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Stage updateStage(@RequestBody Stage stage) {
        return service.updateStage(stage);
    }

    @DeleteMapping("/stage/delete/{id}")
    @PreAuthorize("hasRole('ADMIN') or")
    public String deleteStage(@PathVariable int id) {
        return service.deleteStage(id);
    }


}