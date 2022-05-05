package com.company.abstractFactory;

public class Main {
    public static void main(String[] args) {
        FruitFactory factory = new FruitFactoryFirstPair();
        Client client = new Client(factory);
        client.publish();

        factory = new FruitFactorySecondPair();
        client = new Client(factory);
        client.publish();
    }
}
