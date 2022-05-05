package com.company.builder;

public class Main {
    public static void main(String[] args) {
        Builder BananaBuilder = new BananaBuilder();
        Director director = new Director(BananaBuilder);
        director.Construct();
        BananaBuilder.getFruit().print();
    }
}
