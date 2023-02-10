package com.example.venus_teah_poketeam_casestudy.controller;

import com.example.venus_teah_poketeam_casestudy.model.Team;
import com.example.venus_teah_poketeam_casestudy.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/teams")
    public List<Team> getAllTeams(@RequestParam(required = false) String title) {

        return teamService.getAllTeams();
    }

    @GetMapping("/team/{id}")
    public Optional<Team> getTeamById(@PathVariable("id") Long teamId) {
        return teamService.getTeamById(teamId);
    }

    @PostMapping("/team/new" )
    public void createTeam(@RequestBody Team teamObject) {
        teamService.createTeam(teamObject);
    }

    @PutMapping("/update/team/{teamId}")
    public void updateTeam(@PathVariable Long teamId, @RequestBody Team teamObject) {
        teamService.updateTeam(teamId, teamObject);
    }
    @DeleteMapping("/team/{id}")
    public void deleteTeamById(@PathVariable("id") Long id) {
        teamService.deleteTeamById(id);
    }

    @DeleteMapping("/team")
    public void deleteTeam() {
        teamService.deleteAllTeams();
    }

}
