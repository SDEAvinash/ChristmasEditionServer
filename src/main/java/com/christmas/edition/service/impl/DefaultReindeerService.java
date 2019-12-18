package com.christmas.edition.service.impl;


import com.christmas.edition.model.Reindeer;
import com.christmas.edition.repo.ReindeerRepo;
import com.christmas.edition.service.ReindeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultReindeerService implements ReindeerService {

    private final ReindeerRepo reindeerRepo;

    @Autowired
    public DefaultReindeerService(ReindeerRepo reindeerRepo) {
        this.reindeerRepo = reindeerRepo;
    }

    @Override
    public Reindeer createReindeer(String name) {
        Reindeer reindeer = new Reindeer();
        reindeer.setName(name);
        return reindeerRepo.save(reindeer);
    }

    @Override
    public Reindeer updateReindeer(Reindeer reindeer) {
        return reindeerRepo.save(reindeer);
    }

    @Override
    public Reindeer deleteReindeer(Reindeer reindeer) {
        reindeerRepo.delete(reindeer);
        return reindeer;
    }

    @Override
    public Reindeer retrieve(String name) {
        return reindeerRepo.findByName(name);
    }

    @Override
    public List<Reindeer> retrieveAllReindeers() {
        return reindeerRepo.findAll();
    }
}
