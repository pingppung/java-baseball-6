package baseball.view;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_PROMPT = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getNumbers() {
        return inputWithPrompt(INPUT_NUMBER_PROMPT);
    }

    public int getRestartOrEnd() {
        String input = inputWithPrompt(RESTART_OR_END_PROMPT);
        int number = InputValidator.validateNonNumeric(input);
        InputValidator.validateRestartOrEndNumber(number);
        return number;
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine().trim();
    }
}
