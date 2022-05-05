package com.company.visitor;

public class BadGuy implements Visitor{
    @Override
    public void visit(Screen screen) {
        System.out.println("Разбил экран");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Вырвал клавиши");
    }
}
