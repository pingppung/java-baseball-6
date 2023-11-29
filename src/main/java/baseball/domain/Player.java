package baseball.domain;

import baseball.utils.InputValidator;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player(String input) {
        validate(input);
    }

    private void validate(String input) {
        InputValidator.validateNonNumeric(input);
        InputValidator.validateNumberLength(input);
        InputValidator.validateDuplicateNumber(input);
        InputValidator.validateNumberInRange(input);
    }
}
