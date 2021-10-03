package baseball.domain.baseball;

public class GuessResult {

    private final int strike;
    private final int ball;

    private GuessResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public GuessResult() {
        this(0, 0);
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
        return strike == 0 && ball == 0;
    }
}
