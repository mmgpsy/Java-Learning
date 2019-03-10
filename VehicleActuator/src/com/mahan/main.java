package com.mahan;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Car car = new Car();
        car.fuel(20);
        car.start();
        car.go(150);
        car.go(150);
        car.exit();
    }
}

