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
public class PatientService {
    @Autowired
    private PatientRepos patientRepos;
    @Autowired
    private ClinicRepos clinicRepos;
    @Autowired
    private Mail mail;

    @Transactional
    public List<Patient> getByName(String name) {
        List<Patient> patientList = patientRepos.findAllByFirstName(name);
        return patientList;
    }

    @Transactional
    public List<Patient> getByLastName(String name) {
        List<Patient> patientList = patientRepos.findAllByLastName(name);
        return patientList;
    }

    @Transactional
    public Patient getByAllStatements(String firstname, String lastname, String clinicname) {
        Clinic clinic = clinicRepos.findClinicByName(clinicname);
        if (clinic != null) {
            Patient patient = patientRepos.findPatientByFirstNameAndLastNameAndClinic(firstname, lastname, clinic);
            return patient;
        }
        return null;
    }

    @Transactional
    public Patient addPatient(String clinicname, String first_name, String last_name){

        Clinic clinic = clinicRepos.findClinicByName(clinicname);
        if(clinic != null){
            Patient patient = getByAllStatements(first_name, last_name, clinicname);
            if(patient == null){
                patient = new Patient(first_name, last_name);
                patient.setClinic(clinic);
                patient = patientRepos.save(patient);
                mail.sendEmail("anastasiiac73@gmail.com", "Spring Boot Info", "Patient " +
                        first_name+  " "+ last_name + " added");
                return patient;
            }
        }
        log.info("Patient was added " + first_name + " " + last_name);
        return null;
    }


    
}
