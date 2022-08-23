package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle air = new Airplane();
        Vehicle air1 = new Airplane();
        Vehicle train = new Train();
        Vehicle train1 = new Train();
        Vehicle bus = new Autobus();
        Vehicle bus1 = new Autobus();
        Vehicle[] vehicles = {air, train, bus, air1, train1, bus1};
        for (Vehicle current : vehicles) {
            System.out.println(current);
            current.fuel();
            current.move();
        }
    }
}
