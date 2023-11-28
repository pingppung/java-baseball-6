package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("입력값이_3자리일_경우")
    @Test
    void validateInputNumberLength() {
        String input = "123";
        inputValidator.validateNumberLength(input);
    }

    @DisplayName("입력값이_3자리가_아닌_경우_예외처리")
    @Test
    void invalidateInputNumberLength() {
        String input = "12345";
        assertThatThrownBy(() -> inputValidator.validateNumberLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3글자가 아닙니다.");
    }
}
