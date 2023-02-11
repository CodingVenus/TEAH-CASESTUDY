package com.example.venus_teah_poketeam_casestudy.service;

import com.example.venus_teah_poketeam_casestudy.model.Team;
import com.example.venus_teah_poketeam_casestudy.model.Trainer;
import com.example.venus_teah_poketeam_casestudy.repository.TeamRepository;
import com.example.venus_teah_poketeam_casestudy.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerTeamService {

    private TrainerRepository trainerRepository;
    private TeamRepository teamRepository;

    @Autowired
    public TrainerTeamService(TrainerRepository trainerRepository, TeamRepository teamRepository) {
        this.trainerRepository = trainerRepository;
        this.teamRepository = teamRepository;
    }


    public void addTrainerToTeam(Long teamId, Long trainerId) {

        Team existingTeam = teamRepository.findById(teamId).get();
        Trainer newTrainer = trainerRepository.findById(trainerId).get();

        newTrainer.setName(newTrainer.getName());
        newTrainer.setTeam(existingTeam);
//        existingTeam.getTrainerList().add(newTrainer);
        trainerRepository.save(newTrainer);

    }




}
