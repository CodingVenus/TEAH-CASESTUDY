package org.venus_teah_poketeam_casestudy.security.controller;

import org.venus_teah_poketeam_casestudy.security.model.User;
import org.venus_teah_poketeam_casestudy.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {


        User user = userService.getCurrentUser();
        if(user==null){
            return "redirect:/login";
        } else {
        model.addAttribute("user", user);
        }
        if (user.getTrainer()==null) {
            return "redirect:/trainer/new";
        } else {
            return "home_page";
        }
    }
}
