package baseball.domain.baseball;

public class GuessResult {

    private static final int MIN = 0;
    private static final int MAX = 3;

    private final int strike;
    private final int ball;

    private GuessResult(int strike, int ball) {
        validate(strike);
        validate(ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validate(int value) {
        if (value < MIN || value > MAX) {
            throw new GuessResultException(value);
        }
    }

    public GuessResult() {
        this(MIN, MIN);
    }

    public GuessResult addResult(GuessState guessState) {
        if (guessState == GuessState.STRIKE) {
            return new GuessResult(this.strike + 1, this.ball);
        }
        if (guessState == GuessState.BALL) {
            return new GuessResult(this.strike, this.ball + 1);
        }
        return this;
    }

    public int strike() {
        return strike;
    }

    public int ball() {
        return ball;
    }

    public boolean isNothing() {
        return strike == MIN && ball == MIN;
    }

    public boolean isMaxStrike() {
        return strike == MAX;
    }

}
