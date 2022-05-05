package com.example.pr14.controllers;


import com.example.pr14.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@RestController
@RequestMapping("/delete")
public class DeleteController {


    @GetMapping("/all")
    public String deleteClinics() throws SQLException {
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

        String sql = "delete from patients;";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("All clinics removed");
        return "All clinics removed";
    }

    @GetMapping("/{nameC}")
    public String deleteClinic(@PathVariable String nameC) throws SQLException {
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

        String sql = "delete from patients where clinic_name ='"+ nameC +"';";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("Executed");
        return "Executed";
    }
}
