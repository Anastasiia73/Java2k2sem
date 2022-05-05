package com.example.pr14.repos;

import com.example.pr14.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clinicRepos extends JpaRepository<Clinic, Long> {
    Clinic findClinicByName(String name);
    List<Clinic> findAll();
}
