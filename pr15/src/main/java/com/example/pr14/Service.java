package com.example.pr14;

import com.example.pr14.entity.Clinic;

import java.util.ArrayList;
import java.util.Objects;

public class Service {
    public static ArrayList<Clinic> clinics = new ArrayList<>();

    public synchronized static boolean delete(String name){
        if (clinics == null)
            return false;
        for (Clinic clinic : clinics){
            if(Objects.equals(clinic.getName(), name)){
                clinics.remove(clinic);
                return true;
            }

        }
        return false;
    }

    public synchronized static boolean add(Clinic temp){
        if (clinics == null){
            clinics.add(temp);
            return true;
        }
        for (Clinic clinic : clinics){
            if (Objects.equals(clinic.getName(), temp.getName())){
                return false;
            }
        }
        clinics.add(temp);
        return true;
    }

    public synchronized static Clinic find(String name){
        if (clinics == null)
            return null;
        for (Clinic clinic : clinics){
            if (Objects.equals(clinic.getName(), name)){
                return clinic;
            }
        }
        return null;
    }





}
