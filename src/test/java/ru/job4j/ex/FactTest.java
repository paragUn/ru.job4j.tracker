package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-10);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }

    @Test
    public void whenFact5IsResult120() {
        int n = 5;
        int expected = 120;
        int result = new Fact().calc(n);
        assertThat(result).isEqualTo(expected);
    }
}