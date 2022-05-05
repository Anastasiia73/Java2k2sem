package com.example.pr14.repos;

import com.example.pr14.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface patientRepos extends JpaRepository<Patient, Long> {

}
