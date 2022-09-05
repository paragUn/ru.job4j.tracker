package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person currentPerson : persons) {
            if (currentPerson.getPhone().contains(key)
            || currentPerson.getName().contains(key)
            || currentPerson.getSurname().contains(key)
            || currentPerson.getAddress().contains(key)) {
                result.add(currentPerson);
            }
        }
        return result;
    }
}