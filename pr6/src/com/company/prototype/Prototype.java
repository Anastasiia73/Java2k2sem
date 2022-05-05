package com.company.prototype;

public class Prototype implements Cloneable{
    public void print(){
        System.out.println("New prototype");
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
