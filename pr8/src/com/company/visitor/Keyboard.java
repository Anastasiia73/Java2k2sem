package com.company.visitor;

public class Keyboard implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
