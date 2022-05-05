package com.company.visitor;

public class GoodGuy implements Visitor{
    @Override
    public void visit(Screen screen) {
        System.out.println("Протер экран");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Погладил клавиатуру");
    }
}
