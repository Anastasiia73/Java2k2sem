package com.example.pr14.controllers;


import com.example.pr14.Service;
import com.example.pr14.entity.Clinic;
import com.example.pr14.repos.clinicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowingController {

    @Autowired
    private clinicRepos clinicRepos;

    @GetMapping("/all")
    public String showClinic() {
        System.out.println("All clinics show");
        List<Clinic> clinicList = clinicRepos.findAll();
        return clinicList.toString();
    }

    @GetMapping("/{nameC}")
    public String showPatient(@PathVariable String nameC){
        Clinic clinic = clinicRepos.findClinicByName(nameC);
        if(clinic != null)return clinic.toString();
        else return "Clinic not found";

    }

}
