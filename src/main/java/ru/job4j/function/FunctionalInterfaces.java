package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        BiPredicate<Integer, String> biPred = (a, s) -> a % 2 == 0 || map.get(a).length() == 4;
        for (Integer i : map.keySet()) {
            System.out.println(biPred.test(i, map.get(i)) + "Key: " + i + " : Value: " + map.get(i));
        }
        Supplier<List<String>> sup = () -> new ArrayList<String>(map.values());
        List<String> strings = sup.get();
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s1 -> s1.toUpperCase();
        for (String s : strings) {
            System.out.println(func.apply(s));
        }
    }
}