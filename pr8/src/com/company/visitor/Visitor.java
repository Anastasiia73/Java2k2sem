package com.company.visitor;

public interface Visitor {
    void visit(Screen screen);
    void visit(Keyboard keyboard);
}
