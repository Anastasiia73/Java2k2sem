package com.example.pr14.controllers;


import com.example.pr14.Services.ClinicService;
import com.example.pr14.Services.PatientService;
import com.example.pr14.entity.Clinic;
import com.example.pr14.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddingController {

    @Autowired
    private ClinicService clinicService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/{clinic_name}/{clinic_address}")
    public String addClinic(@PathVariable String clinic_name, @PathVariable String clinic_address) {
        Clinic clinic = clinicService.addClinic(clinic_name, clinic_address);
        if(clinic != null){
            return "Clinic " + clinic.getName() + " have been created";
        }
        else return  "Clinic with name " + clinic_name + " already exists";


    }
    @GetMapping("/{nameC}/{first_name}/{last_name}")
    public String addPatient(@PathVariable String nameC, @PathVariable String first_name, @PathVariable String last_name){
        Patient patient = patientService.addPatient(nameC, first_name, last_name);
        if(patient != null){
            return "Patient saved";
        }
        else return "Clinic with name " + nameC + " does not exist";
    }

}