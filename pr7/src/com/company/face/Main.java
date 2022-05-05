package com.company.face;

public class Main {
    public static void main(String[] args) {
        MWpower mWpower = new MWpower();
        SelectTime selectTime = new SelectTime();
        PowerSelect powerSelect = new PowerSelect();

        MWInterface mwInterface = new MWInterface(mWpower, selectTime, powerSelect);

        mwInterface.activate();
        mWpower.powerOff();

    }
}
