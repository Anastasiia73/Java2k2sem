package com.company.builder;

public class AppleBuilder implements Builder{
    Fruit fruit = new Fruit();
    @Override
    public void creatFruit() {
        fruit.createFruit("Apple");
    }

    @Override
    public void setWeight() {
        fruit.setWeight(100);
    }

    @Override
    public Fruit getFruit() {
        return fruit;
    }
}
