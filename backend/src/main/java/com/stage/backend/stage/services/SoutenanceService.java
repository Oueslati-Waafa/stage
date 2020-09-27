package com.stage.backend.stage.services;

import com.stage.backend.stage.Repository.SoutenanceRepository;
import com.stage.backend.stage.entity.Soutenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoutenanceService {

    @Autowired
    private SoutenanceRepository repository;

    public Soutenance saveSoutenance(Soutenance soutenance) {
        return repository.save(soutenance);
    }

    public List<Soutenance> saveSoutenances(List<Soutenance> soutenances) {
        return repository.saveAll(soutenances);
    }

    public List<Soutenance> getSoutenances() {
        return repository.findAll();
    }

    public Soutenance getSoutenanceById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteSoutenance(int id) {
        repository.deleteById(id);
        return "Soutenance removed !! " + id;
    }

    public Soutenance updateSoutenance(Soutenance soutenance) {
        Soutenance existingSoutenance = repository.findById(soutenance.getId()).orElse(null);
        existingSoutenance.setDate(soutenance.getDate());
        existingSoutenance.setTime(soutenance.getTime());
        return repository.save(existingSoutenance);
    }

}
