package com.company.factoryMethod;

public class BananaFactory implements FruitFactory{
    @Override
    public Fruit creatFruit() {
        return new Banana();
    }
}
