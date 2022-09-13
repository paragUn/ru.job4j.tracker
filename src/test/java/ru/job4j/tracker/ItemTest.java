package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenAscByName() {
        List<Item> items = new ArrayList<>(List.of(
                new Item(3, "C"),
                new Item(1, "A"),
                new Item(2, "B")

        ));
        List<Item> expected = new ArrayList<>(List.of(
                new Item(1, "A"),
                new Item(2, "B"),
                new Item(3, "C")

        ));
        items.sort(new ItemAscByName());
        assertThat(items).hasSameElementsAs(expected);
    }

    @Test
    public void whenDescByName() {
        List<Item> items = new ArrayList<>(List.of(
                new Item(2, "A"),
                new Item(3, "J"),
                new Item(1, "Z")

        ));
        List<Item> expected = new ArrayList<>(List.of(
                new Item(1, "Z"),
                new Item(3, "J"),
                new Item(2, "A")

        ));
        items.sort(new ItemDescByName());
        assertThat(items).hasSameElementsAs(expected);
    }
}