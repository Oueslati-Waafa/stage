package com.stage.backend.stage.security.service;

import com.stage.backend.stage.repository.EntrepriseRepository;
import com.stage.backend.stage.model.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public Entreprise saveEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public List<Entreprise> saveEntreprises(List<Entreprise> entreprises) {
        return entrepriseRepository.saveAll(entreprises);
    }

    public List<Entreprise> getEntreprises() {
        return entrepriseRepository.findAll();
    }

    public Entreprise getEntrepriseById(int id) {
        return entrepriseRepository.findById(id).orElse(null);
    }


    public String deleteEntreprise(int id) {
        entrepriseRepository.deleteById(id);
        return "Entreprise removed !! " + id;
    }

    public Entreprise updateEntreprise(Entreprise entreprise) {
        Entreprise existingEntreprise = entrepriseRepository.findById(entreprise.getId()).orElse(null);
        existingEntreprise.setName(entreprise.getName());
        existingEntreprise.setAdresse(entreprise.getAdresse());
        return entrepriseRepository.save(existingEntreprise);
    }
}
