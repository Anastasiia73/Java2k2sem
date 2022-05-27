package com.example.pr14.jmx;

import com.example.pr14.Services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(description = "Application for save DataBase")
public class ScheduleMBean {

    @Autowired
    private SchedulerService schedulerService;

    @ManagedOperation(description = "Save all entities in .csv files on server machine")
    public void save(){
        schedulerService.saveEntities();
    }

}