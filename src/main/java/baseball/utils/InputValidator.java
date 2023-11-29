package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 3자리의 수가 아닙니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 있습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1~9 범위를 벗어난 숫자가 있습니다.";
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자 입력만 가능합니다.";
    private static final int RANDOM_MIN_NUMBER = 1;
    private static final int RANDOM_MAX_NUMBER = 9;
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

    public void validateNumberInRange(String input) {
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit < RANDOM_MIN_NUMBER || digit > RANDOM_MAX_NUMBER) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }
}
