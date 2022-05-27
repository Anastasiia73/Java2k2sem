package com.example.pr14.controllers;


import com.example.pr14.Services.ClinicService;
import com.example.pr14.entity.Clinic;
import com.example.pr14.repos.ClinicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowingController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/all")
    public String showClinic() {
        return clinicService.getAllClinicsToString();
    }

    @GetMapping("/{nameC}")
    public String showPatient(@PathVariable String nameC){
        return clinicService.getClinicByNameToString(nameC);
    }

}
