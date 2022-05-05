package com.example.pr14.controllers;


import com.example.pr14.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/delete")
public class DeleteController {


    @GetMapping("/all")
    public String deleteClinics(){
        Service.clinics = new ArrayList<>();
        System.out.println("All clinics removed");
        return "All clinics removed";
    }

    @GetMapping("/{nameC}")
    public String deleteClinic(@PathVariable String nameC){
        boolean check = Service.delete(nameC);
        if (check){
            System.out.println("Clinic " + nameC + " has been removed");
            return "Clinic " + nameC + " has been removed";
        } else {
            System.out.println("Clinic with name " + nameC + " not found");
            return "Clinic with name " + nameC + " not found";
        }
    }
}
