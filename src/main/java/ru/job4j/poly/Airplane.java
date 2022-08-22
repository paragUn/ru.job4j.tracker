package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.print("flies through the air");
    }

    @Override
    public void fuel() {
        System.out.println("jet fuel");
    }
}
