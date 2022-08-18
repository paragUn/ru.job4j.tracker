package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner userQuestion = new Scanner(System.in);
        System.out.println(userQuestion.nextLine());
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 1 -> System.out.println("Yes");
            case 2 -> System.out.println("No");
            default -> System.out.println("Maybe");
        }
    }
}
