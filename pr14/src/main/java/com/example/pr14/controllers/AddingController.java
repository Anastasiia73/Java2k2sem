package com.example.pr14.controllers;


import com.example.pr14.Service;
import com.example.pr14.entity.Clinic;
import com.example.pr14.entity.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddingController {


    @GetMapping("/clinic/{name}/{address}")
    public String addClinic(@PathVariable String name, @PathVariable String address){
        Clinic clinic = new Clinic(name, address);
        boolean check = Service.add(clinic);
        if (check){
            System.out.println("Clinic " + name + " created");
            return "Clinic " + clinic.getName() + " has been created";
        } else {
            System.out.println("Clinic with this name already exists");
            return "Clinic with this name already exists";
        }
    }



    @GetMapping("/{nameC}/{full}")
    public String addPatient(@PathVariable String nameC, @PathVariable String full){
        Clinic clinic = Service.find(nameC);
        if (clinic == null){
            System.out.println("Clinic " + nameC + " not found");
            return "Clinic " + nameC + " not found";
        }
        String[] names = full.split("\\.");
        Patient patient = new Patient(names[0], names[1]);
        clinic.addPatient(patient);
        System.out.println("Patient enters clinic" + clinic.getName());
        return "Patient enters clinic" + clinic.getName();
    }

}
