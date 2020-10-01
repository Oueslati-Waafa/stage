package com.stage.backend.stage.controller;

import com.stage.backend.stage.model.Soutenance;
import com.stage.backend.stage.security.service.SoutenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class SoutenanceController {

    @Autowired
    private SoutenanceService soutenanceService;

    @PostMapping("/soutenance/addSoutenance")
    @PreAuthorize("hasRole('ADMIN')")
    public Soutenance addSoutenance(@RequestBody Soutenance soutenance)
    {
        return soutenanceService.saveSoutenance(soutenance);
    }


    @GetMapping("/soutenance/Soutenances")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public List<Soutenance> findAllSoutenances() {
        return soutenanceService.getSoutenances();
    }

    @GetMapping("/soutenance/soutenanceById/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Soutenance findStageById(@PathVariable int id) {
        return soutenanceService.getSoutenanceById(id);
    }


    @PutMapping("/soutenance/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Soutenance updateSoutenance(@RequestBody Soutenance soutenance) {
        return soutenanceService.updateSoutenance(soutenance);
    }

    @DeleteMapping("/soutenance/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSoutenance(@PathVariable int id) {
        return soutenanceService.deleteSoutenance(id);
    }

}
