package com.example.pr14.Services;

import com.example.pr14.repos.ClinicRepos;
import com.example.pr14.repos.PatientRepos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Slf4j
public class SchedulerService{

    @Autowired
    private ClinicRepos clinicRepos;
    @Autowired
    private PatientRepos patientRepos;

    @Scheduled(cron = "0 */30 * * * *")
    @Transactional
    public void saveEntities() {
        patientRepos.savePatients();
        clinicRepos.saveClinics();
        log.info("Entities saved");
    }
}