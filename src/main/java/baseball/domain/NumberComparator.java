package baseball.domain;

import java.util.List;

public class NumberComparator {
    private final static String STRIKE = "스트라이크";
    private final static String BALL = "볼";
    private final static String NOTHING = "낫싱";
    private final static int MAX_PITCHES = 3;
    private final List<Integer> computer;
    private final List<Integer> player;

    public NumberComparator(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
    }

    private int totalHitsCount() {
        int count = 0;
        for (int number : player) {
            if (computer.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int strikeCount() {
        int count = 0;
        for (int i = 0; i < MAX_PITCHES; i++) {
            if (computer.get(i).equals(player.get(i))) {
                count++;
            }
        }
        return count;
    }

    public String generateResult() {
        int totalHits = totalHitsCount();
        int strike = strikeCount();
        int ball = totalHits - strikeCount();

        if (totalHits == 0) {
            return NOTHING;
        }
        if (strike == 0) {
            return ball + BALL;
        }
        if (ball == 0) {
            return strike + STRIKE;
        }
        return ball + BALL + " " + strike + STRIKE;
    }

    public boolean isThreeStrikes() {
        return strikeCount() == MAX_PITCHES;
    }
}
