package com.example.pr14.repos;

import com.example.pr14.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepos extends JpaRepository<Clinic, Long> {
    Clinic findClinicByName(String name);
    List<Clinic> findClinicsByAddress(String address);
    List<Clinic> findAll();
    @Modifying
    @Query(value = "COPY postgres.jpa.clinic " +
            "TO 'D:\\2k2sem\\Java\\pr22users\\clinics.csv' " +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveClinics();
}
