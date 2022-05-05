package com.example.pr14.controllers;


import com.example.pr14.Service;
import com.example.pr14.entity.Clinic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowingController {

    @GetMapping("/all")
    public String addClinic(){
        System.out.println("All clinics show");
        return Service.clinics.toString();
    }

    @GetMapping("/{nameC}")
    public String addPatient(@PathVariable String nameC){
        Clinic clinic = Service.find(nameC);
        if (clinic == null){
            System.out.println("Clinic " + nameC + " not found");
            return "Clinic " + nameC + " not found";
        }
        System.out.println("Clinic " + clinic.getName() + " show");
        return clinic.toString();
    }

}
