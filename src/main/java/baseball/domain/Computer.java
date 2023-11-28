package baseball.domain;

import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        createNumbers();
    }

    private void createNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numbers = numberGenerator.generate();
    }
}
