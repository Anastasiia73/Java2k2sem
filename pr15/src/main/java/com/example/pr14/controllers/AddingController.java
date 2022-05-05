package com.example.pr14.controllers;


import com.example.pr14.Service;
import com.example.pr14.entity.Clinic;
import com.example.pr14.entity.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
@RequestMapping("/add")
public class AddingController {


    @GetMapping("/{first_name}/{last_name}/{clinic_name}/{clinic_address}")
    public String addClinic(@PathVariable String clinic_name, @PathVariable String clinic_address, @PathVariable String first_name, @PathVariable String last_name){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    DBConfig.DB_URL,
                    DBConfig.DB_USERNAME,
                    DBConfig.DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("No connection to database");
            System.out.println(e.getMessage());
            return "No connection to database";
        }


        String sql = "insert into patients (first_name,last_name,clinic_name, clinic_address) values (?,?,?,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.err.println("Column not found");
            return "Column not found";
        }


        try {
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);

            preparedStatement.setString(3, clinic_name);
            preparedStatement.setString(4, clinic_address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("This clinic is already exists");
            return "This clinic is already exists";
        }



        System.out.println("Patient" + first_name + " " + last_name + " enters clinic " + clinic_name);
        return "Patient" + first_name + " "+ last_name + " enters clinic " + clinic_name;
    }
    }



//    @GetMapping("/{nameC}/{full}")
//    public String addPatient(@PathVariable String nameC, @PathVariable String full){
//        Clinic clinic = Service.find(nameC);
//        if (clinic == null){
//            System.out.println("Clinic " + nameC + " not found");
//            return "Clinic " + nameC + " not found";
//        }
//        String[] names = full.split("\\.");
//        Patient patient = new Patient(names[0], names[1]);
//        clinic.addPatient(patient);
//        System.out.println("Patient enters clinic" + clinic.getName());
//        return "Patient enters clinic" + clinic.getName();
//    }

//}
