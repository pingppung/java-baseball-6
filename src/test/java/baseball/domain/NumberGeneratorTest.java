package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    private NumberGenerator numberGenerator;
    private List<Integer> computerNumbers;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
        computerNumbers = numberGenerator.generate();
    }

    @DisplayName("컴퓨터_랜덤숫자_3자리_확인")
    @Test
    void computerNumbersSize() {
        assertThat(computerNumbers.size()).isEqualTo(3)
                .withFailMessage("3자리의 수가 아닙니다.");
    }
}
