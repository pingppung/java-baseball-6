package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_PROMPT = "숫자를 입력해주세요 : ";

    public String getNumbers() {
        return inputWithPrompt(INPUT_NUMBER_PROMPT);
    }
    
    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
