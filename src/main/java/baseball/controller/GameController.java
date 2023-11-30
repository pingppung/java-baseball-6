package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.NumberComparator;
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
        do {
            Computer computer = new Computer();
            List<Integer> computerNumbers = computer.getRandomNumbers();
            play(computerNumbers);
        } while (decisionRestartOrEnd());
        outputView.gameQuitMessage();
    }

    public void play(List<Integer> computerNumbers) {

        boolean test = true;
        do {
            String inputNumbers = inputView.getNumbers();
            Player player = new Player(inputNumbers);
            List<Integer> playerNumbers = player.getNumbers();

            NumberComparator numberComparator = new NumberComparator(computerNumbers, playerNumbers);
            outputView.printResult(numberComparator.generateResult());
            test = false;
        } while (test);
    }

    public boolean decisionRestartOrEnd() {
        return inputView.getRestartOrEnd();
    }
}
