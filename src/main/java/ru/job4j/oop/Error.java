package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error error3Parameters = new Error(true, 404, "Not Found");
        Error error3ParameterFalse = new Error(false, 0, "No errors");
        defaultError.printInfo();
        error3Parameters.printInfo();
        error3ParameterFalse.printInfo();
    }
}
