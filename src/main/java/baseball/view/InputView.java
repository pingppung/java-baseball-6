package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_PROMPT = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getNumbers() {
        return inputWithPrompt(INPUT_NUMBER_PROMPT);
    }

    public String getRestartOrEnd() {
        return inputWithPrompt(RESTART_OR_END_PROMPT);
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
