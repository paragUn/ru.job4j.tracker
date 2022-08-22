package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("wrum-wrum-wrum");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println("Number of passengers: " + passenger);
    }

    @Override
    public double toFuel(double fuel) {
        return 53 * fuel;
    }
}
