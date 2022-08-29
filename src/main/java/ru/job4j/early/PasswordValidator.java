package ru.job4j.early;

public class PasswordValidator {
    private static boolean flagContainUpperLetter = false;
    private static boolean flagContainLowerLetter = false;
    private static boolean flagContainDigit = false;
    private static boolean flagContainSpecialSym = false;
    private static boolean flagContainSubstring = false;

    public static String validate(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Empty password.");
        }
        if (password.length() < 8 || password.length() > 32) {
            return "The password length must be in the range [8,32]!!";
        }
        validateSymbols(password);
        if (!flagContainDigit) {
            return "The password must contain numbers";
        }
        if (!flagContainUpperLetter) {
            return "The password must contain upper letter";
        }
        if (!flagContainLowerLetter) {
            return "The password must contain lower letter";
        }
        if (!flagContainSpecialSym) {
            return "The password must contain special symbols";
        }
        if (!containSubstring(password)) {
            return "The password must not contain substrings: qwerty, 12345, password, admin, user!!";
        }
        return password;
    }

    private static void validateSymbols(String password) {
        for (int index = 0; index < password.length(); index++) {
            char current = password.charAt(index);
            if (Character.isDigit(current)) {
                flagContainDigit = true;
            }
            if (Character.isUpperCase(current)) {
                flagContainUpperLetter = true;
            }
            if (Character.isLowerCase(current)) {
                flagContainLowerLetter = true;
            }
            if ((current > 31 && current < 48)
                    || (current > 57 && current < 64)
                    || (current > 90 && current < 97)
                    || (current > 122 && current < 127)) {
                flagContainSpecialSym = true;
            }
        }
    }

    private static boolean containSubstring(String password) {
            return password.contains("qwerty")
                || password.contains("12345")
                || password.contains("password")
                || password.contains("admin")
                || password.contains("user");
    }
}
