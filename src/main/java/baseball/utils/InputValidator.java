package baseball.utils;

import baseball.constants.BaseballConstants;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateNumberLength(String input) {
        int pitchCount = BaseballConstants.PITCHES.value;
        if (input.length() != pitchCount) {
            throw new IllegalArgumentException(ErrorMessages.LENGTH_ERROR.formatMessage(pitchCount));
        }
    }

    public static void validateDuplicateNumber(String input) {
        Set<Integer> numbers = new HashSet<>();
        boolean hasDuplicate = input.chars()
                .mapToObj(Character::getNumericValue)
                .anyMatch(i -> !numbers.add(i));

        if (hasDuplicate) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_ERROR.message);
        }
    }

    public static void validateNumberInRange(String input) {
        int randomMax = BaseballConstants.RANDOM_MAX_NUMBER.value;
        int randomMin = BaseballConstants.RANDOM_MIN_NUMBER.value;
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit < randomMin || digit > randomMax) {
                throw new IllegalArgumentException(ErrorMessages.RANGE_ERROR.formatMessage(randomMin, randomMax));
            }
        }
    }

    public static int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_ERROR.message);
        }
    }

    public static boolean validateRestartOrEndNumber(int input) {
        int restart = BaseballConstants.RESTART_NUMBER.value;
        int end = BaseballConstants.END_NUMBER.value;
        if (input == restart) {
            return true;
        }
        if (input == end) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessages.GAME_DECISION_ERROR.formatMessage(restart, end));

    }
}
