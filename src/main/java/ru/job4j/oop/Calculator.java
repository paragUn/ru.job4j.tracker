package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int num) {
        return num - x;
    }

    public int divide(int num) {
        return num / x;
    }

    public int sumAllOperation(int num) {
        return sum(num) + multiply(num) + minus(num) + divide(num);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int minusResult = minus(10);
        int multiplyResult = calculator.multiply(10);
        int divideResult = calculator.divide(10);
        int sumOfAllOperationsResult = calculator.sumAllOperation(10);
        System.out.println(minusResult);
        System.out.println(multiplyResult);
        System.out.println(divideResult);
        System.out.println(sumOfAllOperationsResult);
    }
}