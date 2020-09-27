package com.stage.backend.stage.controller;

import com.stage.backend.stage.entity.Soutenance;
import com.stage.backend.stage.services.SoutenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class SoutenanceController {

    @Autowired
    private SoutenanceService soutenanceService;

    @PostMapping("/soutenance/addSoutenance")
    public Soutenance addSoutenance(@RequestBody Soutenance soutenance)
    {
        return soutenanceService.saveSoutenance(soutenance);
    }


    @GetMapping("/soutenance/Soutenances")
    public List<Soutenance> findAllSoutenances() {
        return soutenanceService.getSoutenances();
    }

    @GetMapping("/soutenance/soutenanceById/{id}")
    public Soutenance findStageById(@PathVariable int id) {
        return soutenanceService.getSoutenanceById(id);
    }


    @PutMapping("/soutenance/update")
    public Soutenance updateSoutenance(@RequestBody Soutenance soutenance) {
        return soutenanceService.updateSoutenance(soutenance);
    }

    @DeleteMapping("/soutenance/delete/{id}")
    public String deleteSoutenance(@PathVariable int id) {
        return soutenanceService.deleteSoutenance(id);
    }

}
