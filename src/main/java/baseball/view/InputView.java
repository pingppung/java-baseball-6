package baseball.view;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_PROMPT = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getNumbers() {
        return inputWithPrompt(INPUT_NUMBER_PROMPT);
    }

    public boolean getRestartOrEnd() {
        String input = inputWithPrompt(RESTART_OR_END_PROMPT + "\n");
        int number = InputValidator.validateNonNumeric(input);
        return InputValidator.validateRestartOrEndNumber(number);
    }

    private String inputWithPrompt(String prompt) {
        System.out.print(prompt);
        return Console.readLine().trim();
    }
}
