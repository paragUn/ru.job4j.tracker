package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void whenValidPassword() {
        String in = "MG+7n8Fz}^C74p";
        String expected = "MG+7n8Fz}^C74p";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNullPassword() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(null));
        assertThat(exception.getMessage()).isEqualTo("Empty password.");
    }

    @Test
    public void whenEmptyPassword() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(""));
        assertThat(exception.getMessage()).isEqualTo("Empty password.");
    }

    @Test
    public void whenLengthLessThan8Password() {
        String in = "MG+7n";
        String expected = "The password length must be in the range [8,32]!!";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenLengthGreaterThan32Password() {
        String in = "ni|P,Qsa0F874{.RJ|v50K5{aLO%3&bt0";
        String expected = "The password length must be in the range [8,32]!!";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenDoesNotContainNumber() {
        String in = "MG+nFz}^Cp";
        String expected = "The password must contain numbers";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenDoesNotContainUpperLetter() {
        String in = "+7n8z}^74p";
        String expected = "The password must contain upper letter";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenDoesNotContainLowerLetter() {
        String expected = "The password must contain lower letter";
        String in = "MG+78F}^C74";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenDoesNotContainSpecialSymbols() {
        String expected = "The password must contain special symbols";
        String in = "MG7n8FzC74p";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenContainQwerty() {
        String expected = "The password must not contain substrings: qwerty, 12345, password, admin, user!!";
        String in = "MG+7n8Fz}^C74pqwerty";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenContain12345() {
        String expected = "The password must not contain substrings: qwerty, 12345, password, admin, user!!";
        String in = "MG+7n8F12345z}^C74p";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenContainLiterallyPassword() {
        String expected = "The password must not contain substrings: qwerty, 12345, password, admin, user!!";
        String in = "MG+pasSword7n8Fz}^C74p";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenContainLiterallyAdmin() {
        String expected = "The password must not contain substrings: qwerty, 12345, password, admin, user!!";
        String in = "MG+7n8Fz}^Cadmin74p";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenContainLiterallyUsEr() {
        String expected = "The password must not contain substrings: qwerty, 12345, password, admin, user!!";
        String in = "MG+7n8Fz}user^74p";
        String result = PasswordValidator.validate(in);
        assertThat(result).isEqualTo(expected);
    }
}