package com.company.abstractFactory;

public class FruitFactoryFirstPair implements FruitFactory{
    @Override
    public Apple createApple() {
        return new AppleRed();
    }

    @Override
    public Banana createBanana() {
        return new YellowBanana();
    }
}
