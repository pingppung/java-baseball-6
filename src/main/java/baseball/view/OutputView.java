package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String CORRECT_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! ";
    private static final String GAME_END_MESSAGE = "게임 종료";

    public void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void gameEndMessage() {
        System.out.print(CORRECT_MESSAGE);
        gameQuitMessage();
    }

    public void gameQuitMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
