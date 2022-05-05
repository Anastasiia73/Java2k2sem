package com.company;

public class Main {

    public static void main(String[] args) {
        Singleton1 singleton1 = new Singleton1();
        singleton1.getInstance();
        System.out.println(singleton1);
        Singleton1 singleton5 = new Singleton1();
        System.out.println(singleton5.getInstance());
        Singleton2 singleton2 = Singleton2.INSTANCE;
        System.out.println(singleton2);
        Singleton2 singleton6 = Singleton2.INSTANCE;
        System.out.println(singleton6);
        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println(singleton3);
    }
}
