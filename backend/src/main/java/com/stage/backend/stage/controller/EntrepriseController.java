package com.stage.backend.stage.controller;

import com.stage.backend.stage.model.Entreprise;
import com.stage.backend.stage.security.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntrepriseController {
    @Autowired
    private EntrepriseService entrepriseService;

    @PostMapping("/entreprise/addEntreprise")
    public Entreprise addEntreprise(@RequestBody Entreprise entreprise)
    {
        return entrepriseService.saveEntreprise(entreprise);
    }


    @GetMapping("/entreprise/Entreprises")
    public List<Entreprise> findAllEntreprises() {
        return entrepriseService.getEntreprises();
    }

    @GetMapping("/entreprise/entrepriseById/{id}")
    public Entreprise findStageById(@PathVariable int id) {
        return entrepriseService.getEntrepriseById(id);
    }


    @PutMapping("/entreprise/update")
    public Entreprise updateEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseService.updateEntreprise(entreprise);
    }

    @DeleteMapping("/entreprise/delete/{id}")
    public String deleteEntreprise(@PathVariable int id) {
        return entrepriseService.deleteEntreprise(id);
    }
}
