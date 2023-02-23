package org.venus_teah_poketeam_casestudy.controller;

import org.venus_teah_poketeam_casestudy.model.Team;
import org.venus_teah_poketeam_casestudy.model.Trainer;
import org.venus_teah_poketeam_casestudy.repository.TeamRepository;
import org.venus_teah_poketeam_casestudy.security.model.User;
import org.venus_teah_poketeam_casestudy.security.repository.UserRepository;
import org.venus_teah_poketeam_casestudy.security.service.UserService;
import org.venus_teah_poketeam_casestudy.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    /**RETURNS PAGE WHERE YOU CAN CHOOSE YOUR TEAM**/
    @RequestMapping("/team/new") //having post-mapping gives error. changed to request
    public String showTeam() {

        return "team_choice";
    }

    /**UPDATES TRAINER CHOICE OF TEAM**/
    @RequestMapping("/teamchoice/{id}") //having post-mapping gives error. changed to request
    public String chooseTeam(@PathVariable("id") Long id, Model model) {
        //Get Team
        Team teamChoice = teamService.getTeamById(id);

        //Get current user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userRepository.findByEmail(username);


        //Get Trainer from User and set Team
        Trainer trainer = user.getTrainer();
        trainer.setTeam(teamChoice); //trainer already exists so needs to be updated

        //Get List from Team and add Trainers
        List<Trainer> currentTrainers = teamChoice.getTrainerList();
        currentTrainers.add(trainer); //add trainer to team list

        teamChoice.setTrainerList(currentTrainers);
        teamRepository.save(teamChoice);

        model.addAttribute("teamChoice", teamChoice);
        return "home_page";
    }


    /**RETURNS VERDANT PAGE**/
    @RequestMapping("/team/Verdant")
    public String getVerdantTeamPage(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "grass_team";
    }

    /**RETURNS CRIMSON PAGE**/
    @RequestMapping("/team/Crimson")
    public String getCrimsonTeamPage(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "fire_team";
    }

    /**RETURNS AZURE PAGE**/
    @RequestMapping("/team/Azure")
    public String getAzureTeamPage(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "water_team";
    }

}
