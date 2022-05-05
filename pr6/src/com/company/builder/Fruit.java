package com.company.builder;

public class Fruit {
    private String name;
    private int weight;

    public void createFruit(String name){
        this.name=name;
    }
    public void setWeight(int weight){
        this.weight=weight;
    }
    public void print(){
        System.out.println(name + " weight " + weight);
    }
}
