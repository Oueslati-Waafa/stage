package com.stage.backend.stage.services;
import com.stage.backend.stage.Repository.RapportRepository;
import com.stage.backend.stage.entity.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    public Rapport saveRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }



    public List<Rapport> getRapports() {
        return rapportRepository.findAll();
    }

    public Rapport getRapportById(int id) {
        return rapportRepository.findById(id).orElse(null);
    }


    public String deleteRapport(int id) {
        rapportRepository.deleteById(id);
        return "Rapport removed !! " + id;
    }

    public Rapport updateRapport(Rapport rapport) {
        Rapport existingRapport = rapportRepository.findById(rapport.getId()).orElse(null);
        existingRapport.setEtat(rapport.getEtat());
        return rapportRepository.save(existingRapport);
    }
}
