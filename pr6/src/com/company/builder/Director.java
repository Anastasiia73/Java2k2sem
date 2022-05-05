package com.company.builder;

public class Director {
    Builder builder;

    Director(Builder builder){
        this.builder=builder;
    }

    public void Construct(){
        builder.creatFruit();
        builder.setWeight();
    }
}
