package com.example.pr14.controllers;

import com.example.pr14.Services.UserService;
import com.example.pr14.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class RegLogController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/index"})
    public String getHome(){
        return "/home";
    }


    @GetMapping("/login")
    public String getLogin() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }

        return "login";
    }

    @GetMapping("/register")
    public String getForm(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/";
        }

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute("user") @Valid User user,
                               Model model){

        if (user.getUsername().length() < 5){
            model.addAttribute("errorLenUsername", true);
            return "register";
        }
        if (!Objects.equals(user.getPassword(), user.getPasswordConfirm())){
            model.addAttribute("errorConfPassword", true);
            return "register";
        }
        if (user.getPassword().length() < 5){
            model.addAttribute("errorLenPassword", true);
            return "register";
        }
        if (userService.findUserByUsername(user.getUsername()) != null){
            model.addAttribute("errorAlreadyExistsUsername", true);
            return "register";
        }
        try{
            userService.saveUser(user);
            return "redirect:/login";
        } catch (Exception e){
            model.addAttribute("errorAnomaly", true);
            return "register";
        }
    }

}
