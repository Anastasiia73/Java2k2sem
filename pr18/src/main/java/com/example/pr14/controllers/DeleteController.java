package com.example.pr14.controllers;


import com.example.pr14.Services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteController {
    @Autowired
    private ClinicService clinicService;

    @GetMapping("/all")
    public String deleteClinics(){
        clinicService.deleteAll();
        return "Successful";
    }

    @GetMapping("/{nameC}")
    public String deleteClinic(@PathVariable String nameC){
        if (clinicService.deleteClinic(nameC) != null)
            return "Successful";
        else
            return "Clinic with this name doesnt exist";
    }
}
