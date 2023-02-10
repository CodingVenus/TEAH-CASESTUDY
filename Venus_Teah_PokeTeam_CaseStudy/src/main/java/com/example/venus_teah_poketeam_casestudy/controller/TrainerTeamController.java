package com.example.venus_teah_poketeam_casestudy.controller;

import com.example.venus_teah_poketeam_casestudy.model.Trainer;
import com.example.venus_teah_poketeam_casestudy.service.TrainerService;
import com.example.venus_teah_poketeam_casestudy.service.TrainerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerTeamController {
    @Autowired
    TrainerTeamService trainerTeamService;

    @PutMapping("/{teamId}/trainers/{trainerId}")
    public void addTrainerToTeam(
            @PathVariable Long teamId,
            @PathVariable Long trainerId)
    {
        trainerTeamService.addTrainerToTeam(teamId, trainerId);
    }
}
