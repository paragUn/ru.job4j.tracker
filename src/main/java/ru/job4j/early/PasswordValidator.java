package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        boolean flagUpperLetter = false;
        boolean flagLowerLetter = false;
        boolean flagDigit = false;
        boolean flagSpecialSym = false;

        if (password == null) {
            throw new IllegalArgumentException("Empty password.");
        }

        if (password.length() < 8 || password.length() > 32) {
            return "The password length must be in the range [8,21]!!";
        }

        for (int index = 0; index < password.length(); index++) {
            char current = password.charAt(index);
            if (Character.isDigit(current)) {
                flagDigit = true;
            }
            if (Character.isLowerCase(current)) {
                flagLowerLetter = true;
            }
            if (Character.isUpperCase(current)) {
                flagUpperLetter = true;
            }
            if ((current > 31 && current < 48)
                    || (current > 57 && current < 64)
                    || (current > 90 && current < 97)
                    || (current > 122 && current < 127)) {
                flagSpecialSym = true;
            }
        }

        if (!flagDigit) {
            return "The password must contain numbers";
        }

        if (!flagUpperLetter) {
            return "The password must contain upper Letter";
        }

        if (!flagLowerLetter) {
            return "The password must contain lower letter";
        }

        if (!flagSpecialSym) {
            return "The password must contain lower letter";
        }

    return password;
    }

    public static void main(String[] args) {
        System.out.println(Character.isAlphabetic(123));
    }
}
