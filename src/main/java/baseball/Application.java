package baseball;

import baseball.controller.BaseBallGame;
import baseball.domain.baseball.GuessResult;
import baseball.ui.InputView;
import baseball.ui.ResultView;

public class Application {

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
            String inputNumbers = InputView.inputNumbers();
            GuessResult guessResult = baseBallGame.guess(inputNumbers);
            ResultView.print(guessResult);
        }
    }

}
