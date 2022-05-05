package com.company.adapter;

public class Adapter implements EUSocket{
    private USPlug usPlug;

    public Adapter(USPlug usPlug){
        this.usPlug = usPlug;
    }

    @Override
    public void plugInto() {
        this.usPlug.isPlugged();
    }
}
