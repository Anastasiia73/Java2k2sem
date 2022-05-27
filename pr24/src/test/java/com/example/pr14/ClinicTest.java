package com.example.pr14;

import com.example.pr14.entity.Clinic;
import com.example.pr14.repos.ClinicRepos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClinicTest {
    @Mock
    private ClinicRepos clinicRepos;

    @Test
    void getClinics(){
        Clinic clinic = new Clinic();
        clinic.setName("VetMed");
        Clinic clinic1 = new Clinic();
        clinic1.setName("NeVetMed");
        Mockito.when(clinicRepos.findAll()).thenReturn(List.of(clinic, clinic1));
        Assertions.assertEquals(2, clinicRepos.findAll().size());
        Assertions.assertEquals("VetMed", clinicRepos.findAll().get(0).getName());
    }

}
