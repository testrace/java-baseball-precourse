package baseball;

import baseball.controller.BaseBallGame;
import baseball.domain.baseball.GuessResult;
import baseball.domain.number.NumberException;
import baseball.domain.number.NumbersException;
import baseball.ui.InputView;
import baseball.ui.ResultView;

public class Application {

    private static final String ERROR_INPUT = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";

    public static void main(String[] args) {

        BaseBallGame baseBallGame = new BaseBallGame();

        play(baseBallGame);

        while (InputView.continueGame()) {
            play(baseBallGame);
        }

    }

    private static void play(BaseBallGame baseBallGame) {
        baseBallGame.start();
        while (baseBallGame.isPlaying()) {
            GuessResult guessResult = getGuessResult(baseBallGame);
            ResultView.print(guessResult);
        }
    }

    private static GuessResult getGuessResult(BaseBallGame baseBallGame) {
        String inputNumbers = InputView.inputNumbers();
        try {
            return baseBallGame.guess(inputNumbers);
        } catch (NumbersException | NumberException ex) {
            System.err.println(ERROR_INPUT);
            return getGuessResult(baseBallGame);
        }
    }
}
