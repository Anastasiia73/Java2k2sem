package com.company.abstractFactory;

public class FruitFactorySecondPair implements FruitFactory{
    @Override
    public Apple createApple() {
        return new GreenApple();
    }

    @Override
    public Banana createBanana() {
        return new GreenBanana();
    }
}
