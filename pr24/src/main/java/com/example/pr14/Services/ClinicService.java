package com.example.pr14.Services;


import com.example.pr14.entity.Clinic;
import com.example.pr14.entity.Patient;
import com.example.pr14.repos.ClinicRepos;
import com.example.pr14.repos.PatientRepos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ClinicService {
    @Autowired
    private ClinicRepos clinicRepos;
    @Autowired
    private PatientRepos patientRepos;
    @Autowired
    private Mail mail;

    @Transactional
    public Clinic addClinic(String name, String address){
        Clinic clinic = new Clinic(name, address);
        log.info("Clinic was added " + name + " " + address);
        if(clinicRepos.findClinicByName(clinic.getName())==null){
            Clinic savedClinic = clinicRepos.saveAndFlush(clinic);
            mail.sendEmail("anastasiiac73@gmail.com", "Spring Boot Info", "Clinic " + name + " added");
            return savedClinic;
        }
        else return null;
    }

    @Transactional
    public Clinic deleteClinic(String name){
        log.info("Clinic was deleted " + name);
        Clinic deletedClinic = clinicRepos.findClinicByName(name);
        if(deletedClinic != null){
            clinicRepos.delete(deletedClinic);
            mail.sendEmail("anastasiiac73@gmail.com", "Spring Boot Info", "Clinic " + name + " deleted");
        }
        return null;
    }

    @Transactional
    public List<Clinic> getAll(){
        List<Clinic> allClinics = clinicRepos.findAll();
        return allClinics;
    }

    @Transactional
    public String getAllClinicsToString(){
        return clinicRepos.findAll().toString();
    }

    @Transactional
    public String getClinicByNameToString(String name){
        Clinic temp = clinicRepos.findClinicByName(name);
        if (temp != null)
            return temp.toString();
        else
            return "Not found clinic with name - " + name;
    }

    @Transactional
    public void deleteAll(){
        clinicRepos.deleteAll();
        log.info("Clinics were deleted");
    }

    @Transactional
    public String filtering(String value){
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
