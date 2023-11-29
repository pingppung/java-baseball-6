package baseball.domain;

import baseball.utils.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numbers;

    public Player(String input) {
        validate(input);
        this.numbers = convertInputToNumbers(input);
    }

    private void validate(String input) {
        InputValidator.validateNonNumeric(input);
        InputValidator.validateNumberLength(input);
        InputValidator.validateDuplicateNumber(input);
        InputValidator.validateNumberInRange(input);
    }

    private List<Integer> convertInputToNumbers(String input) {
        List<Integer> convertedNumbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            convertedNumbers.add(number);
        }
        return convertedNumbers;
    }
}
