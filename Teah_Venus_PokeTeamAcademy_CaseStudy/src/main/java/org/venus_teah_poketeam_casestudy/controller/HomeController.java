package org.venus_teah_poketeam_casestudy.controller;

import org.venus_teah_poketeam_casestudy.security.model.User;
import org.venus_teah_poketeam_casestudy.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    UserService userService;


    @RequestMapping("/homepage")
    public String getHomePage(Model model){
       User user = userService.getCurrentUser();
       model.addAttribute("user", user);
        return "home_page";
    }

    @RequestMapping("/games")
    public String getGamePage(Model model){
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "games";
    }





}
