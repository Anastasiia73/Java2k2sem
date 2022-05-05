package com.example.pr14.entity;

import lombok.Data;
import java.util.ArrayList;


@Data
public class Clinic {
    private String name;
    private String address;
    private ArrayList<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
