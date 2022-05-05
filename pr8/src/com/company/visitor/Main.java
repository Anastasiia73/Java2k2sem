package com.company.visitor;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        Keyboard keyboard = new Keyboard();

        BadGuy badGuy = new BadGuy();
        badGuy.visit(screen);
        badGuy.visit(keyboard);

        System.out.println("================");

        GoodGuy goodGuy = new GoodGuy();
        goodGuy.visit(screen);
        goodGuy.visit(keyboard);
    }
}
