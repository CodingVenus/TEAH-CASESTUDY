package org.venus_teah_poketeam_casestudy.service;

import org.venus_teah_poketeam_casestudy.model.Team;
import org.venus_teah_poketeam_casestudy.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    //POST
    public Team createTeam(Team teamObject) {


        return teamRepository.save(teamObject);

    }

    //GET BY ID
    public Team getTeamById(Long teamId) {

        return teamRepository.findById(teamId).get();

    }

    //GET ALL
    public List<Team> getAllTeams() {

        return teamRepository.findAll();
    }

    //UPDATE
    public Team updateTeam(Long teamId, Team teamObject) {
//
        Team existingTeam = teamRepository.findById(teamId).get();
        existingTeam.setName(teamObject.getName());

        return teamRepository.save(existingTeam);
    }

    public Team getTeamByName(String name) {
        return teamRepository.getTeamByNameIgnoreCase(name);
    }


    //DELETE
    //BY ID
    public void deleteTeamById(Long teamId) {

        teamRepository.deleteById(teamId);
    }

    //ALL
    public void deleteAllTeams() {

        teamRepository.deleteAll();
    }


}
