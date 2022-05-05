package com.company.builder;

public class BananaBuilder implements Builder{
    Fruit fruit = new Fruit();
    @Override
    public void creatFruit() {
        fruit.createFruit("Banana");
    }

    @Override
    public void setWeight() {
        fruit.setWeight(200);
    }

    @Override
    public Fruit getFruit() {
        return fruit;
    }
}
