package com.example.venus_teah_poketeam_casestudy.controller;

import com.example.venus_teah_poketeam_casestudy.model.Trainer;
import com.example.venus_teah_poketeam_casestudy.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {
    @Autowired
    TrainerService trainerService;

    @GetMapping("/trainers")
    public List<Trainer> getAllTrainers(@RequestParam(required = false) String title) {

        return trainerService.getAllTrainers();
    }

    @GetMapping("/trainer/{id}")
    public Optional<Trainer> getTrainerById(@PathVariable("id") Long trainerId) {
        return trainerService.getTrainerById(trainerId);
    }

    @PostMapping("/new" )
    public void createTextBook(@RequestBody Trainer trainerObject) {
        trainerService.createTrainer(trainerObject);
    }

    @PutMapping("/update/{trainerId}")
    public void createTextBook(@PathVariable Long trainerId, @RequestBody Trainer trainerObject) {
        trainerService.updateTrainer(trainerId, trainerObject);
    }
    @DeleteMapping("/trainer/{id}")
    public void deleteTextBook(@PathVariable("id") Long id) {
        trainerService.deleteTrainerById(id);
    }

    @DeleteMapping("/trainer")
    public void deleteTextBook() {
        trainerService.deleteAllTrainers();
    }

}
