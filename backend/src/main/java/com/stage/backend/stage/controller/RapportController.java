package com.stage.backend.stage.controller;

import com.stage.backend.stage.model.Rapport;
import com.stage.backend.stage.security.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RapportController {
    @Autowired
    private RapportService rapportService;

    @PostMapping("/rapport/addRapport")
    public Rapport addRapport(@RequestBody Rapport rapport)
    {
        return rapportService.saveRapport(rapport);
    }


    @GetMapping("/rapport/Rapports")
    public List<Rapport> findAllRapports() {
        return rapportService.getRapports();
    }

    @GetMapping("/rapport/rapportById/{id}")
    public Rapport findRapportById(@PathVariable int id) {
        return rapportService.getRapportById(id);
    }


    @PutMapping("/rapport/update")
    public Rapport updateRapport(@RequestBody Rapport rapport) {
        return rapportService.updateRapport(rapport);
    }

    @DeleteMapping("/rapport/delete/{id}")
    public String deleteRapport(@PathVariable int id) {
        return rapportService.deleteRapport(id);
    }
}
