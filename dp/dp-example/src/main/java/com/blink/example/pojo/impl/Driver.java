package com.blink.example.pojo.impl;

import com.blink.example.pojo.ICar;
import com.blink.example.pojo.IDriver;

public class Driver implements IDriver {
    private ICar iCar;

    public Driver(ICar iCar) {
        this.iCar = iCar;
    }

    @Override
    public void driver() {
        System.out.println("开始驾驶汽车...start");
        iCar.run();
        System.out.println("开始驾驶汽车...end");
    }
}
