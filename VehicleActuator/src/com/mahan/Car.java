package com.mahan;

import static java.lang.System.out;

public class Car {
    private int distance;
    private String status;
    private int tank;
    private int usedTank;
    private static int maxFuelTank;

    static {
        maxFuelTank = 50;
    }

    public Car() {
        setStatus("Stop");
        setDistance(0);
        setTank(0);
    }

    public int getUsedTank() {
        return usedTank;
    }

    public void setUsedTank(int usedTank) {
        this.usedTank = usedTank;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public void start() {
        String Err = "";
        if ("Stop".equals(this.status)) {
            setStatus("Start");
            Err = "Car has started successfully.";
        } else {
            Err = "Car has already started.";
        }
        System.out.println(Err);
    }

    public void stop() {
        String Err = "";
        if ("Start".equals(this.status)) {
            setStatus("Stop");
            Err = "Car has stopped successfully.";
        } else {
            Err = "Car has already stopped.";
        }
        System.out.println(Err);
    }

    public void go(int givenDistance) {
        String Err = "";
        if ("Start".equals(this.status)) {
            if (this.tank > 0) {
                int neededFuel = givenDistance == 0 ? 0 : (givenDistance / 10);
                if (this.tank >= neededFuel) {
                    this.tank -= neededFuel;
                    this.usedTank += neededFuel;
                    this.distance += givenDistance;
                    Err = "The requested distance " + givenDistance + " KM is travelled successfully.";
                } else {

                    Err = "Car doesn't have enough fuel for your distance. Please fuel the car.";
                }
            } else {
                Err = "Whenever you want to use the car, first you have to fuel it. Tank is empty.";
            }
        } else {
            Err = "Car hasn't started yet in order to go any distance.";
        }
        System.out.println(Err);
    }

    public void fuel(int requestedFuel) {
        String Err = "";
        if ("Stop".equals(this.status)) {
            int totalFuel = this.tank + requestedFuel;
            if (maxFuelTank >= totalFuel) {
                this.tank = totalFuel;
                Err = "The requested fuel " + requestedFuel + " L is fueled successfully.";
            } else {
                Err = "The maximum car's tank is about 50, you've requested more than the limited.";
            }
        } else {
            Err = "Please first stop the car.";
        }
        System.out.println(Err);

    }

    public void exit() {
        String Err = "The taken distance is : " + this.distance + " KM" + "\n" +
                "The used fuel is : " + this.usedTank + "\n" +
                "The remained fuel is : " + this.tank;
        System.out.println(Err);
    }
}
