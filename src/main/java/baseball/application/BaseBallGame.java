package baseball.application;

import baseball.application.dto.GuessResult;
import baseball.domain.GuessScore;
import baseball.domain.GuessState;
import baseball.domain.number.LocationNumber;
import baseball.domain.number.NumberFactory;
import baseball.domain.number.Numbers;
import java.util.List;

public class BaseBallGame {

    public GuessResult guess(List<Integer> selectedNumbers, String inputNumbers) {
        Numbers hostNumbers = NumberFactory.convert(selectedNumbers);
        Numbers clientNumbers = NumberFactory.convert(inputNumbers);
        GuessScore guessScore = new GuessScore();
        for (LocationNumber clientNumber : clientNumbers.getLocationNumbers()) {
            guessScore.addScore(getGuessState(hostNumbers, clientNumber));
        }

        return createGuessResult(guessScore);
    }

    private static GuessResult createGuessResult(GuessScore guessScore) {
        GuessResult guessResult = new GuessResult();
        guessResult.setBall(guessScore.getScore(GuessState.BALL));
        guessResult.setStrike(guessScore.getScore(GuessState.STRIKE));
        guessResult.setGameOver(guessScore.isGameOver());
        return guessResult;
    }

    private GuessState getGuessState(Numbers hostNumbers, LocationNumber clientNumber) {
        return GuessState.of(hostNumbers, clientNumber);
    }

}
