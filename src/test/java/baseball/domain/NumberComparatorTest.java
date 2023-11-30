package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberComparatorTest {
    private List<Integer> computerNumbers;

    @BeforeEach
    void setUp() {
        computerNumbers = List.of(1, 2, 3);
    }

    @DisplayName("3스트라이크의_여부")
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, true",
            "1, 2, 4, false"
    })
    public void isThreeStrikes(int ball1, int ball2, int ball3, boolean expectedResult) {
        List<Integer> playerNumbers = List.of(ball1, ball2, ball3);
        NumberComparator numberComparator = new NumberComparator(computerNumbers, playerNumbers);
        assertEquals(expectedResult, numberComparator.isThreeStrikes());
    }

    @DisplayName("볼_개수_확인")
    @ParameterizedTest
    @CsvSource({
            "2, 4, 5, 1볼",
            "2, 3, 5, 2볼",
            "2, 3, 1, 3볼"
    })
    public void isBallStrikes(int ball1, int ball2, int ball3, String expectedResult) {
        List<Integer> playerNumbers = List.of(ball1, ball2, ball3);
        NumberComparator numberComparator = new NumberComparator(computerNumbers, playerNumbers);
        assertEquals(expectedResult, numberComparator.generateResult());
    }

    @DisplayName("겹치는_숫자가_없을때_낫싱_결과_확인")
    @Test
    void isNothing() {
        List<Integer> playerNumbers = List.of(4, 5, 6);
        NumberComparator numberComparator = new NumberComparator(computerNumbers, playerNumbers);
        assertEquals("낫싱", numberComparator.generateResult());
    }

    @DisplayName("볼과_스트라이크가_혼합된_결과_확인")
    @ParameterizedTest
    @CsvSource({
            "1, 3, 5, 1볼 1스트라이크",
            "2, 1, 3, 2볼 1스트라이크",
    })
    void isBallsAndStrikes(int ball1, int ball2, int ball3, String expectedResult) {
        List<Integer> playerNumbers = List.of(ball1, ball2, ball3);
        NumberComparator numberComparator = new NumberComparator(computerNumbers, playerNumbers);
        assertEquals(expectedResult, numberComparator.generateResult());
    }
}
