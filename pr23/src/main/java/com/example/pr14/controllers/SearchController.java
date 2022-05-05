package com.example.pr14.controllers;


import com.example.pr14.Services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/filter")
public class SearchController {
    @Autowired
    private ClinicService clinicService;
    @GetMapping("/{value}")
    public String getFilter(@PathVariable String value){
        return clinicService.filtering(value);
    }
}
