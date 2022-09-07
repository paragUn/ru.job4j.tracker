package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map  = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("username@gmail.com", "Username UserSurname");
        map.put("username1@gmail.com", "Username UserSurname");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
