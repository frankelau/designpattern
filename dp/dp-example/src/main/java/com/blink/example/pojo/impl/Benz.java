package com.blink.example.pojo.impl;

import com.blink.example.pojo.ICar;

public class Benz implements ICar {
    @Override
    public void run() {
        System.out.println("奔驰汽车开始行驶...");
    }
}
