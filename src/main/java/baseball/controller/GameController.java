package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.gameStartMessage();
        while (true) {  //재시작/종료 로직 추가
            Computer computer = new Computer();
            List<Integer> computerNumbers = computer.getRandomNumbers();
            play(computerNumbers);
            break;
        }
        outputView.gameQuitMessage();
    }

    public void play(List<Integer> computerNumbers) {
        boolean test = true;
        do {
            String inputNumbers = inputView.getNumbers();
            Player player = new Player(inputNumbers);
            //컴퓨터와 사용자의 숫자 비교 로직 추가
            //비교 결과값 출력 로직 추가
            test = false;
        } while (test);
    }
}
