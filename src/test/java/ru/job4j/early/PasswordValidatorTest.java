package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void whenValidPassword() {
        String in = "MG+7n8Fz}^C74";
        String expected = "MG+7n8Fz}^C74";
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
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+7n"));
        assertThat(exception.getMessage()).isEqualTo("The password length must be in the range [8,32]!!");
    }

    @Test
    public void whenLengthGreaterThan32Password() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("ni|P,Qsa0F874{.RJ|v50K5{aLO%3&bt0"));
        assertThat(exception.getMessage()).isEqualTo("The password length must be in the range [8,32]!!");
    }

    @Test
    public void whenDoesNotContainNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+nFz}^Cp"));
        assertThat(exception.getMessage()).isEqualTo("The password must contain numbers");
    }

    @Test
    public void whenDoesNotContainUpperLetter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("+7n8z}^74p"));
        assertThat(exception.getMessage()).isEqualTo("The password must contain upper letter");
    }

    @Test
    public void whenDoesNotContainLowerLetter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+78F}^C74"));
        assertThat(exception.getMessage()).isEqualTo("The password must contain lower letter");
    }

    @Test
    public void whenDoesNotContainSpecialSymbols() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG7n8FzC74p"));
        assertThat(exception.getMessage()).isEqualTo("The password must contain special symbols");
    }

    @Test
    public void whenContainQwerty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+7n8Fz}^C74pqWeRtY"));
        assertThat(exception.getMessage()).isEqualTo("The password must not contain substrings: qwerty, 12345, password, admin, user");

    }

    @Test
    public void whenContain12345() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+7n8F12345z}^C74p"));
        assertThat(exception.getMessage()).isEqualTo("The password must not contain substrings: qwerty, 12345, password, admin, user");
    }

    @Test
    public void whenContainLiterallyPassword() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+pasSword7n8Fz}^C74p"));
        assertThat(exception.getMessage()).isEqualTo("The password must not contain substrings: qwerty, 12345, password, admin, user");
    }

    @Test
    public void whenContainLiterallyAdmin() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+7n8Fz}^CAdmin74p"));
        assertThat(exception.getMessage()).isEqualTo("The password must not contain substrings: qwerty, 12345, password, admin, user");
    }

    @Test
    public void whenContainLiterallyUsEr() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("MG+7n8Fz}UsEr^74p"));
        assertThat(exception.getMessage()).isEqualTo("The password must not contain substrings: qwerty, 12345, password, admin, user");
    }
}