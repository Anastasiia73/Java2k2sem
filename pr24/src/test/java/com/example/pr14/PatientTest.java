package com.example.pr14;

import com.example.pr14.entity.Patient;
import com.example.pr14.repos.PatientRepos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PatientTest {
    @Mock
    private PatientRepos patientRepos;

    @Test
    void getPatients(){
        Patient patient = new Patient();
        patient.setFirstName("Alexey");
        Patient patient1 = new Patient();
        patient1.setFirstName("Max");
        Mockito.when(patientRepos.findAll()).thenReturn(List.of(patient, patient1));
        Assertions.assertEquals(2, patientRepos.findAll().size());
        Assertions.assertEquals("Alexey", patientRepos.findAll().get(0).getFirstName());
    }

}
