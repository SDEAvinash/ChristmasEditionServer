package com.christmas.edition.service;

import com.christmas.edition.model.Reindeer;
import java.util.List;

public interface ReindeerService {

  Reindeer createReindeer(String name);

  Reindeer updateReindeer(Reindeer reindeer);

  Reindeer deleteReindeer(Reindeer reindeer);

  List<Reindeer> retrieveAllReindeers();

  Reindeer retrieve(String name);
}
