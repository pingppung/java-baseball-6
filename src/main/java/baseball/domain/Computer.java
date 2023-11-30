package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        createRandomNumbers();
    }

    private void createRandomNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();
        this.numbers = numberGenerator.generate();
    }

    public List<Integer> getRandomNumbers() {
        return new ArrayList<>(numbers);
    }
}
