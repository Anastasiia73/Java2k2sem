package com.example.pr14.entity;


import javax.persistence.*;
import java.util.List;


@Table(name = "clinic")
@Entity
public class Clinic {
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic", fetch = FetchType.LAZY)
    private List<Patient> patients;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", patients=" + patients +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Clinic() {

    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
