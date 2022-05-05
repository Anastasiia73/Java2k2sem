package com.company.abstractFactory;

public class Client {
    private final Apple apple;
    private final Banana banana;

    public Client(FruitFactory factory) {
        apple = factory.createApple();
        banana = factory.createBanana();
    }

    public void publish(){
        apple.fall();
        banana.fall();
    }
}
