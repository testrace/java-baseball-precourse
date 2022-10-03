package baseball.ui;

import baseball.application.dto.GuessResult;
import java.util.function.Predicate;

public enum ResultMessage {

    BALL("%d볼", GuessResult::hasBall),
    STRIKE("%d스트라이크", GuessResult::hasStrike),
    NOTHING("낫싱", GuessResult::isNothing),
    BOTH(String.format("%s %s", BALL.format, STRIKE.format), GuessResult::hasBallAndStrike);

    private final String format;
    private final Predicate<GuessResult> predicate;

    ResultMessage(String format, Predicate<GuessResult> predicate) {
        this.format = format;
        this.predicate = predicate;
    }

    public static String from(GuessResult guessResult) {
        if (NOTHING.match(guessResult)) {
            return NOTHING.format;
        }

        return bothOrEach(guessResult);
    }

    private static String bothOrEach(GuessResult guessResult) {
        if (BOTH.match(guessResult)) {
            return String.format(BOTH.format, guessResult.getBall(), guessResult.getStrike());
        }

        return ballOrStrike(guessResult);
    }

    private static String ballOrStrike(GuessResult guessResult) {
        if (BALL.match(guessResult)) {
            return String.format(BALL.format, guessResult.getBall());
        }

        return String.format(STRIKE.format, guessResult.getStrike());
    }

    private boolean match(GuessResult guessResult) {
        return this.predicate.test(guessResult);
    }
}
