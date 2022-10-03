package baseball;

import baseball.application.BaseBallGame;
import baseball.application.NumberPicker;
import baseball.application.NumberSelector;
import baseball.application.RandomNumberPicker;
import baseball.application.dto.GuessResult;
import baseball.ui.InputView;
import baseball.ui.ResultView;
import java.util.List;

public class Application {

    private static final int COUNT_OF_NUMBERS = 3;
    private static final NumberSelector NUMBER_SELECTOR = new NumberSelector();
    private static final NumberPicker NUMBER_PICKER = new RandomNumberPicker();
    private static final BaseBallGame BASE_BALL_GAME = new BaseBallGame();

    public static void main(String[] args) {

        play(NUMBER_SELECTOR.select(COUNT_OF_NUMBERS, NUMBER_PICKER));

        while (InputView.continueGames()) {
            play(NUMBER_SELECTOR.select(COUNT_OF_NUMBERS, NUMBER_PICKER));
        }
    }

    private static void play(final List<Integer> selectedNumbers) {
        tryGuess(selectedNumbers);
        ResultView.printGameOver();
    }

    private static void tryGuess(List<Integer> selectedNumbers) {
        GuessResult guessResult = new GuessResult();

        while (!guessResult.isGameOver()) {
            String inputNumbers = InputView.inputNumbers();
            guessResult = BASE_BALL_GAME.guess(selectedNumbers, inputNumbers);

            ResultView.printScore(guessResult);
        }
    }
}
