package com.example.pr14.controllers;


import com.example.pr14.Service;
import com.example.pr14.entity.Clinic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/show")
public class ShowingController {

    @GetMapping("/all")
    public String addClinic() throws SQLException {
        System.out.println("All clinics show");
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

        String sql = "SELECT * from patients;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String answer = "";
        while(resultSet.next()){
            String first_name = resultSet.getString(1);
            String last_name = resultSet.getString(2);
            String clinic_name = resultSet.getString(3);
            String clinic_address = resultSet.getString(4);
            answer += first_name + " : " + last_name + " : " + clinic_name + " : " + clinic_address + "\n";
        }
        return answer;
    }

    @GetMapping("/{nameC}")
    public String addPatient(@PathVariable String nameC) throws SQLException {
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

        String sql = "SELECT * from patients where clinic_name='" + nameC + "';";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String answer = "";
        while(resultSet.next()){
            String first_name = resultSet.getString(1);
            String last_name = resultSet.getString(2);
            String clinic_name = resultSet.getString(3);
            String clinic_address = resultSet.getString(4);
            answer += first_name + " : " + last_name + " : " + clinic_name + " : " + clinic_address + "\n";
        }
        return answer;
    }

}
