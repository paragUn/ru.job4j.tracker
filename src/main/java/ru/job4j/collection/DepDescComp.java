package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
            return Integer.compare(o1.length(), o2.length());
        }
        int result = o2.split("/")[0].compareTo(o1.split("/")[0]);
        if (result != 0) {
            return result;
        }
        for (int i = 1; i < o1.length(); i++) {
            result = o1.split("/")[i].compareTo(o2.split("/")[i]);
            if (result != 0) {
                return result;
            }
        }
        return result;
    }
}