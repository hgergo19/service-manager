package hu.hjst.jobmanager.utils;

public class Validator {

    public static void validate(String text, String message) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validate(Object o, String message) {
        if (o == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validatePositiveNumber(Number n, String message) {
        if (n.longValue() <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
