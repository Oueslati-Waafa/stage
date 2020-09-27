package com.stage.backend.stage.services;
import com.stage.backend.stage.Repository.RapportRepository;
import com.stage.backend.stage.entity.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportService {

    @Autowired
    private RapportRepository repository;

    public Rapport saveRapport(Rapport rapport) {
        return repository.save(rapport);
    }



    public List<Rapport> getRapports() {
        return repository.findAll();
    }

    public Rapport getRapportById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteRapport(int id) {
        repository.deleteById(id);
        return "Rapport removed !! " + id;
    }

    public Rapport updateRapport(Rapport rapport) {
        Rapport existingRapport = repository.findById(rapport.getId()).orElse(null);
        existingRapport.setEtat(rapport.getEtat());
        return repository.save(existingRapport);
    }
}
