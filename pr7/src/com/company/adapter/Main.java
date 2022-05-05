package com.company.adapter;

public class Main {
    public static void main(String[] args) {
        EUSocket adapter = new Adapter(new USPlug());
        adapter.plugInto();
    }
}
