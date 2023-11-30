package baseball.constants;

public enum BaseballConstants {
    RANDOM_MIN_NUMBER(1),
    RANDOM_MAX_NUMBER(9),
    PITCHES(3),
    RESTART_NUMBER(1),
    END_NUMBER(2);

    public final int value;

    BaseballConstants(int value) {
        this.value = value;
    }
}
