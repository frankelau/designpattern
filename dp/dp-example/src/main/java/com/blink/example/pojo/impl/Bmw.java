package com.blink.example.pojo.impl;

import com.blink.example.pojo.ICar;

public class Bmw implements ICar {
    @Override
    public void run() {
        System.out.println("宝马汽车开始行驶...");
    }
}
