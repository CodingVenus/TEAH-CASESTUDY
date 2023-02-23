package org.venus_teah_poketeam_casestudy.security.controller;

import org.venus_teah_poketeam_casestudy.security.model.CustomUserDetails;
import org.venus_teah_poketeam_casestudy.security.service.CustomUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private CustomUserDetailsService userService;

    public RegistrationController(CustomUserDetailsService userService) {
        super();
        this.userService = userService;
    }

    //don't explicitly have to add object to model with add attribute
    @ModelAttribute("user") //invoked before controller methods
    public CustomUserDetails customUserDetails() {
        return new CustomUserDetails();
    }

    @GetMapping // handles http GET request
    public String showRegistrationForm() {
        return "registration";
    }

//    @PostMapping // handles http POST request
//    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
//        userService.save(registrationDto);
//        return "redirect:/registration?success";
//    }

    @PostMapping // handles http POST request
    public String registerUserAccount(@ModelAttribute("user") CustomUserDetails customUserDetails) {
        userService.save(customUserDetails);
        return "redirect:/registration?success";
    }
}
