package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final String LENGTH_ERROR_MESSAGE = "3글자가 아닙니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
    private final static int NUMBER_SIZE = 3;

    public void validateNumberLength(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateNumber(String input) {
        Set<Integer> numbers = new HashSet<>();
        boolean hasDuplicate = input.chars()
                .mapToObj(Character::getNumericValue)
                .anyMatch(i -> !numbers.add(i));

        if (hasDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
