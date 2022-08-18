package ru.job4j.pojo;

public class Book {
    private String name;
    private int countOfPappers;

    public Book(String name, int countOfPappers) {
        this.name = name;
        this.countOfPappers = countOfPappers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfPappers() {
        return countOfPappers;
    }

    public void setCountOfPappers(int countOfPappers) {
        this.countOfPappers = countOfPappers;
    }
}
