package com.stage.backend.stage.controller;

import com.stage.backend.stage.entity.Stage;
import com.stage.backend.stage.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StageController {

    @Autowired
    private StageService service;

    @PostMapping("/stage/addStage")
    public Stage addProduct(@RequestBody Stage stage) {
        return service.saveStage(stage);
    }

    @PostMapping("/stage/addStages")
    public List<Stage> addProducts(@RequestBody List<Stage> products) {
        return service.saveStages(products);
    }

    @GetMapping("/stage/Stages")
    public List<Stage> findAllProducts() {
        return service.getStages();
    }

    @GetMapping("/stage/stageById/{id}")
    public Stage findProductById(@PathVariable int id) {
        return service.getStageById(id);
    }

    @GetMapping("/stage/stage/{name}")
    public Stage findProductByName(@PathVariable String name) {
        return service.getStageByName(name);
    }

    @PutMapping("/stage/update")
    public Stage updateProduct(@RequestBody Stage stage) {
        return service.updateStage(stage);
    }

    @DeleteMapping("/stage/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteStage(id);
    }
}