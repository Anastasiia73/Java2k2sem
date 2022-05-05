package com.company.factoryMethod;

public class AppleFactory implements FruitFactory{
    @Override
    public Fruit creatFruit() {
        return new Apple();
    }
}
