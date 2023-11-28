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

    @DisplayName("입력값에_중복된_숫자가_존재하지_않는_경우")
    @Test
    void validateDuplicateNumber() {
        String input = "123";
        inputValidator.validateDuplicateNumber(input);
    }

    @DisplayName("입력값에_중복된_숫자가_존재할_경우")
    @Test
    void invalidateDuplicateNumber() {
        String input = "112";
        assertThatThrownBy(() -> inputValidator.validateDuplicateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 있습니다.");
    }
}
