package com.example.pr14.controllers;


import com.example.pr14.entity.Clinic;
import com.example.pr14.repos.ClinicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteController {
    @Autowired
    private ClinicRepos clinicRepos;

    @GetMapping("/all")
    public String deleteClinics(){
        clinicRepos.deleteAll();
        return "Successful";
    }

    @GetMapping("/{nameC}")
    public String deleteClinic(@PathVariable String nameC){
        Clinic clinic = clinicRepos.findClinicByName(nameC);
        if (clinic == null) return "Clinic is not find";
        clinicRepos.delete(clinic);
        return "Successful";
    }
}
