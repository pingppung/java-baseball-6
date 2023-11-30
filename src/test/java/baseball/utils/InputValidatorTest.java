package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.constants.BaseballConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputValidatorTest {


    @DisplayName("입력값이_지정_길이일_경우")
    @Test
    void validateInputNumberLength() {
        String input = "123";
        InputValidator.validateNumberLength(input);
    }

    @DisplayName("입력값이_지정_길이가_아닌_경우_예외처리")
    @Test
    void invalidateInputNumberLength() {
        String input = "12345";
        int pitchCount = BaseballConstants.PITCHES.value;
        assertThatThrownBy(() -> InputValidator.validateNumberLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.LENGTH_ERROR.formatMessage(pitchCount));
    }

    @DisplayName("입력값에_중복된_숫자가_존재하지_않는_경우")
    @Test
    void validateDuplicateNumber() {
        String input = "123";
        InputValidator.validateDuplicateNumber(input);
    }

    @DisplayName("입력값에_중복된_숫자가_존재할_경우")
    @Test
    void invalidateDuplicateNumber() {
        String input = "112";
        assertThatThrownBy(() -> InputValidator.validateDuplicateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATE_ERROR.message);
    }

    @DisplayName("입력값이_유효한_범위내에_존재하는_경우")
    @Test
    void validateNumberInRange() {
        String input = "137";
        InputValidator.validateNumberInRange(input);
    }

    @DisplayName("입력값의_숫자가_범위를 벗어나는_경우")
    @Test
    void invalidateNumberInRange() {
        String input = "109";
        int randomMax = BaseballConstants.RANDOM_MAX_NUMBER.value;
        int randomMin = BaseballConstants.RANDOM_MIN_NUMBER.value;
        assertThatThrownBy(() -> InputValidator.validateNumberInRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.RANGE_ERROR.formatMessage(randomMin, randomMax));
    }

    @DisplayName("입력값에_문자없이_숫자로만_이루어진_경우")
    @Test
    void validateNonNumeric() {
        String input = "123";
        InputValidator.validateNonNumeric(input);
    }

    @DisplayName("입력값에_문자가_존재하는_경우")
    @Test
    void invalidateNonNumeric() {
        String input = "1S2";
        assertThatThrownBy(() -> InputValidator.validateNonNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NON_NUMERIC_ERROR.message);
    }

    @DisplayName("게임_재시작_또는_종료_확인")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, false"
    })
    void validateRestartOrEndGame(int number, boolean expectedResult) {
        assertEquals(expectedResult, InputValidator.validateRestartOrEndNumber(number));
    }

    @DisplayName("게임_재시작_또는_종료값이_아닌_다른_숫자_입력_예외처리")
    @Test
    void invalidateRestartOrEndGame() {
        int input = 3;
        int restart = BaseballConstants.RESTART_NUMBER.value;
        int end = BaseballConstants.END_NUMBER.value;
        assertThatThrownBy(() -> InputValidator.validateRestartOrEndNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.GAME_DECISION_ERROR.formatMessage(restart, end));
    }
}
