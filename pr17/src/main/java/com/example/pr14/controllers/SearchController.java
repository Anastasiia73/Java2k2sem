package com.example.pr14.controllers;


import com.example.pr14.entity.Clinic;
import com.example.pr14.entity.Patient;
import com.example.pr14.repos.ClinicRepos;
import com.example.pr14.repos.PatientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/filter")
public class SearchController {
    @Autowired
    private ClinicRepos clinicRepos;
    @Autowired
    private PatientRepos patientRepos;
    @GetMapping("/{value}")
    public String getFilter(@PathVariable String value){
        String output = "By clinic name:\n";
        Clinic clinicByName = clinicRepos.findClinicByName(value);
        if (clinicByName != null)
            output += clinicByName.toString() + "\n";
        else
            output += "Not found\n";
        List<Clinic> clinicsByAddress = clinicRepos.findClinicsByAddress(value);
        output += "By clinic address:\n";
        if (clinicsByAddress.size() != 0)
            output += clinicsByAddress.toString() + "\n";
        else
            output += "Not found\n";
        List<Patient> patientsByFirst = patientRepos.findAllByFirstName(value);
        output += "By patient firtsname";
        if (patientsByFirst.size() != 0)
            output += patientsByFirst.toString() + "\n";
        else
            output += "Not found\n";
        List<Patient> patientsByLast = patientRepos.findAllByLastName(value);
        output += "By patient lastname";
        if (patientsByLast.size() != 0)
            output += patientsByLast.toString() + "\n";
        else
            output += "Not found\n";
        return output;
    }
}
