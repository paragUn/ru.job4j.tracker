package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> testPhone = (s) -> s.getPhone().contains(key);
        Predicate<Person> testName = (s) -> s.getName().contains(key);
        Predicate<Person> testSurname = (s) -> s.getSurname().contains(key);
        Predicate<Person> testAddress = (s) -> s.getAddress().contains(key);
        Predicate<Person> combine = testPhone.or(testName).or(testSurname).or(testAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}