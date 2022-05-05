package com.company.face;

public class MWInterface {
    private MWpower mWpower;
    private SelectTime selectTime;
    private PowerSelect powerSelect;

    public MWInterface(MWpower mWpower, SelectTime selectTime,PowerSelect powerSelect){
        this.mWpower = mWpower;
        this.selectTime = selectTime;
        this.powerSelect = powerSelect;
    }

    public void activate(){
        mWpower.powerOn();
        selectTime.selectTime();
        powerSelect.powerSelect();
    }
}
