package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .flatMap(Stream::ofNullable)
                .collect(Collectors.toMap(
                        Student::getSurname,
                        e -> e,
                        (existing, replacement) -> existing
                ));

    }
}