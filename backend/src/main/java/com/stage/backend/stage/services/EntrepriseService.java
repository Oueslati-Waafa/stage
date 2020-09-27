package com.stage.backend.stage.services;

import com.stage.backend.stage.Repository.EntrepriseRepository;
import com.stage.backend.stage.entity.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository repository;

    public Entreprise saveEntreprise(Entreprise entreprise) {
        return repository.save(entreprise);
    }

    public List<Entreprise> saveEntreprises(List<Entreprise> entreprises) {
        return repository.saveAll(entreprises);
    }

    public List<Entreprise> getEntreprises() {
        return repository.findAll();
    }

    public Entreprise getEntrepriseById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteEntreprise(int id) {
        repository.deleteById(id);
        return "Entreprise removed !! " + id;
    }

    public Entreprise updateEntreprise(Entreprise entreprise) {
        Entreprise existingEntreprise = repository.findById(entreprise.getId()).orElse(null);
        existingEntreprise.setName(entreprise.getName());
        existingEntreprise.setAdresse(entreprise.getAdresse());
        return repository.save(existingEntreprise);
    }
}
