package baseball.ui;

import baseball.domain.baseball.GuessResult;

public enum ResultMessage {
    STRIKE_AND_BALL("%d스트라이크 %d볼", guessResult -> guessResult.strike() > 0 && guessResult.ball() > 0),
    STRIKE("%d스트라이크", guessResult -> guessResult.strike() > 0 && guessResult.ball() == 0),
    BALL("%d볼", guessResult -> guessResult.strike() == 0 && guessResult.ball() > 0),
    NOTHING("낫싱", guessResult -> guessResult.strike() == 0 && guessResult.ball() == 0);

    private final String message;
    private final ResultMessageOperator operator;

    ResultMessage(String message, ResultMessageOperator operator) {
        this.message = message;
        this.operator = operator;
    }

    public static ResultMessage of(GuessResult guessResult) {
        ResultMessage resultMessage = NOTHING;
        for (ResultMessage value : values()) {
            boolean apply = value.operator.apply(guessResult);
            resultMessage = apply ? value : resultMessage;
        }
        return resultMessage;
    }

    public String message(GuessResult guessResult) {
        if (this == BALL) {
            return String.format(message, guessResult.ball());
        }
        return String.format(message, guessResult.strike(), guessResult.ball());
    }

}
