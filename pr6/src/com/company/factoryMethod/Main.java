package com.company.factoryMethod;

public class Main {
    public static void main(String[] args) {
        FruitFactory factory = new AppleFactory();
        Fruit apple = factory.creatFruit();
        apple.fall();

        factory = new BananaFactory();
        Fruit banana = factory.creatFruit();
        banana.fall();

    }
}
