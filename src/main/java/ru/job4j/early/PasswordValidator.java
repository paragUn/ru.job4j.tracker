package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Empty password.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("The password length must be in the range [8,32]!!");
        }
        if (!containDigit(password)) {
            throw new IllegalArgumentException("The password must contain numbers");
        }
        if (!containUpperLetter(password)) {
            throw new IllegalArgumentException("The password must contain upper letter");
        }
        if (!containLowerLetter(password)) {
            throw new IllegalArgumentException("The password must contain lower letter");
        }
        if (!containSpecialSym(password)) {
            throw new IllegalArgumentException("The password must contain special symbols");
        }
        if (!containSubstring(password)) {
            throw new IllegalArgumentException("The password must not contain substrings: qwerty, 12345, password, admin, user");
        }
        return "Your password is valid!";
    }

    private static boolean containDigit(String password) {
        boolean result  = false;
        for (int index = 0; index < password.length(); index++) {
            char current = password.charAt(index);
            if (Character.isDigit(current)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean containUpperLetter(String password) {
        boolean result  = false;
        for (int index = 0; index < password.length(); index++) {
            char current = password.charAt(index);
            if (Character.isUpperCase(current)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean containLowerLetter(String password) {
        boolean result  = false;
        for (int index = 0; index < password.length(); index++) {
            char current = password.charAt(index);
            if (Character.isLowerCase(current)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean containSpecialSym(String password) {
        boolean result  = false;
        for (int index = 0; index < password.length(); index++) {
            char current = password.charAt(index);
            if ((current > 31 && current < 48)
                    || (current > 57 && current < 64)
                    || (current > 90 && current < 97)
                    || (current > 122 && current < 127)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean containSubstring(String password) {
            return !password.toLowerCase().contains("qwerty")
                && !password.toLowerCase().contains("12345")
                && !password.toLowerCase().contains("password")
                && !password.toLowerCase().contains("admin")
                && !password.toLowerCase().contains("user");
    }
}
