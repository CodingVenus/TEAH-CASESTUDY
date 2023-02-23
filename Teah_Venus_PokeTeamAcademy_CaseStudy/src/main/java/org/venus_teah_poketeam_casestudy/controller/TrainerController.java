package org.venus_teah_poketeam_casestudy.controller;

import org.venus_teah_poketeam_casestudy.model.Trainer;
import org.venus_teah_poketeam_casestudy.security.model.CustomUserDetails;
import org.venus_teah_poketeam_casestudy.security.service.UserService;
import org.venus_teah_poketeam_casestudy.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @Autowired
    UserService userService;


    @ModelAttribute("user")
    public CustomUserDetails customUserDetails() {
        return new CustomUserDetails();
    }


    /**
     * CREATES TRAINER FROM FORM
     **/
    @RequestMapping("/trainer/new")
    public String createTrainer(Model model) {

        model.addAttribute("trainer", new Trainer());

        return "trainer_form";

    }

    /**
     * SAVES TRAINER TO DB
     **/
    @PostMapping("/trainer/save")
    public String saveCreatedTrainer(@Valid Trainer trainer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            return "trainer_form";
        } else {

            trainerService.createTrainer(trainer);

            return "redirect:/team/new";
        }
    }

}

