package com.example.pr14.repos;

import com.example.pr14.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepos extends JpaRepository<Patient, Long> {
    List<Patient> findAllByFirstName(String first_name);
    List<Patient> findAllByLastName(String last_name);
}
