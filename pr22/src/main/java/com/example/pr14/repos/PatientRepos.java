package com.example.pr14.repos;

import com.example.pr14.entity.Clinic;
import com.example.pr14.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepos extends JpaRepository<Patient, Long> {
    List<Patient> findAllByFirstName(String first_name);
    List<Patient> findAllByLastName(String last_name);
    Patient findPatientByFirstNameAndLastNameAndClinic(String Firstname, String Lastname, Clinic clinic);
    @Modifying
    @Query(value = "COPY postgres.jpa.patient " +
            "TO 'D:\\2k2sem\\Java\\pr22users\\patients.csv' " +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void savePatients();
}
