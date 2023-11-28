package baseball.utils;

public class InputValidator {
    private static final String LENGTH_ERROR_MESSAGE = "3글자가 아닙니다.";
    private final static int NUMBER_SIZE = 3;

    public void validateLength(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }
}
