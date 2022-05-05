package com.example.pr14.controllers;


import com.example.pr14.entity.Clinic;
import com.example.pr14.entity.Patient;
import com.example.pr14.repos.PatientRepos;
import com.example.pr14.repos.ClinicRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddingController {

    @Autowired
    private ClinicRepos clinicRepos;
    @Autowired
    private PatientRepos patientRepos;

    @GetMapping("/{clinic_name}/{clinic_address}")
    public String addClinic(@PathVariable String clinic_name, @PathVariable String clinic_address) {
        if (clinicRepos.findClinicByName(clinic_name) != null) return "Clinic with this name already exist";
        Clinic clinic = new Clinic(clinic_name, clinic_address);
        clinicRepos.save(clinic);
        return "Clinic created";


    }
    @GetMapping("/{nameC}/{first_name}/{last_name}")
    public String addPatient(@PathVariable String nameC, @PathVariable String first_name, @PathVariable String last_name){
        Clinic clinic = clinicRepos.findClinicByName(nameC);
        if (clinic == null)return "Clinic is not find";
        Patient patient = new Patient(first_name, last_name);
        patient.setClinic(clinic);
        patientRepos.save(patient);
        return "Successful";
    }

}