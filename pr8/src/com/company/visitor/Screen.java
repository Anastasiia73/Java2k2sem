package com.company.visitor;

public class Screen implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
