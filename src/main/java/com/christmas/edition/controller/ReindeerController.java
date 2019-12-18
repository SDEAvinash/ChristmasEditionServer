package com.christmas.edition.controller;

import com.christmas.edition.exception.AlreadyExistsException;
import com.christmas.edition.exception.NotFoundException;
import com.christmas.edition.model.Reindeer;
import com.christmas.edition.service.ReindeerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/reindeer")
public class ReindeerController {

  private final ReindeerService reindeerService;

  @Autowired
  public ReindeerController(ReindeerService reindeerService) {
    this.reindeerService = reindeerService;
  }

  @GetMapping("")
  public List<Reindeer> fetchAllReindeer() {
    return reindeerService.retrieveAllReindeers();
  }

  @PostMapping("/{name}")
  public Reindeer createReindeer(@PathVariable(name = "name") String name) {
    Assert.hasLength(name, "Reindeer name cannot be empty.");
    Reindeer reindeer = reindeerService.retrieve(name);
    if (reindeer != null) {
      throw new AlreadyExistsException("Reindeer already exists: " + name);
    }
    return reindeerService.createReindeer(name);
  }

  @DeleteMapping("/{name}")
  public Reindeer deleteReindeer(@PathVariable(name = "name") String name) {
    Reindeer reindeer = reindeerService.retrieve(name);
    if (reindeer == null) {
      throw new NotFoundException("Reindeer cannot be found: " + name);
    }
    return reindeerService.deleteReindeer(reindeer);
  }

  @PutMapping("/{name}")
  public Reindeer renameReindeer(@PathVariable(name = "name") String name,
      @RequestBody Reindeer req) {
    Assert.hasLength(req.getName(), "Reindeer name cannot be empty.");
    Reindeer reindeer = reindeerService.retrieve(name);
    if (reindeer == null) {
      throw new NotFoundException("Reindeer cannot be found: " + name);
    }
    reindeer.setName(req.getName());
    return reindeerService.updateReindeer(reindeer);
  }
}
