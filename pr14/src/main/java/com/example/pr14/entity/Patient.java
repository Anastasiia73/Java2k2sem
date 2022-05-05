package com.example.pr14.entity;

import com.example.pr14.entity.Clinic;
import lombok.Data;

@Data
public class Patient {
    private String firstName;
    private String lastName;

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
