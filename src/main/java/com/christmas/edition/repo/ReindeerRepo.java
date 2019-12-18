package com.christmas.edition.repo;


import com.christmas.edition.model.Reindeer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ReindeerRepo extends CrudRepository<Reindeer, Integer> {

  List<Reindeer> findAll();

  Reindeer findByName(String name);
}
