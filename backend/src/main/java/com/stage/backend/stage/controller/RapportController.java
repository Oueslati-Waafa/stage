package com.stage.backend.stage.controller;

import com.stage.backend.stage.model.Rapport;
import com.stage.backend.stage.security.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RapportController {
    @Autowired
    private RapportService rapportService;

    @PostMapping("/rapport/addRapport")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Rapport addRapport(@RequestBody Rapport rapport)
    {
        return rapportService.saveRapport(rapport);
    }


    @GetMapping("/rapport/Rapports")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public List<Rapport> findAllRapports() {
        return rapportService.getRapports();
    }

    @GetMapping("/rapport/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public Rapport findRapportById(@PathVariable int id) {
        return rapportService.getRapportById(id);
    }


    @PutMapping("/rapport/update")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Rapport updateRapport(@RequestBody Rapport rapport) {
        return rapportService.updateRapport(rapport);
    }

    @DeleteMapping("/rapport/delete/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public String deleteRapport(@PathVariable int id) {
        return rapportService.deleteRapport(id);
    }

   }
