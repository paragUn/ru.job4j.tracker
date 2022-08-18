package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Elon Musk");
        student.setGroup("X Æ A-12");
        student.setStartDate(new Date());
        System.out.println(student.getName() + "\n" + student.getGroup() + "\n" + student.getStartDate());
    }
}
