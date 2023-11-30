package baseball.utils;

public enum ErrorMessages {
    LENGTH_ERROR("[ERROR] %d자리의 수가 아닙니다."),
    DUPLICATE_ERROR("[ERROR] 중복된 숫자가 있습니다."),
    RANGE_ERROR("[ERROR] %d~%d 범위를 벗어난 숫자가 있습니다."),
    NON_NUMERIC_ERROR("[ERROR] 숫자 입력만 가능합니다."),
    GAME_DECISION_ERROR("[ERROR] 재시작 : %d or 종료 : %d만 입력이 가능합니다.");

    public final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
