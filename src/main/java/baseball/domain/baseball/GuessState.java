package baseball.domain.baseball;

public enum GuessState {

    STRIKE(GuessState::isStrike),
    BALL(GuessState::isBall),
    NOTHING((number, location) -> true);

    private final GuessStateOperator operator;

    GuessState(GuessStateOperator operator) {
        this.operator = operator;
    }

    public static GuessState of(int guessLocation, int location) {
        if (isStrike(guessLocation, location)) {
            return STRIKE;
        }
        if (isBall(guessLocation, location)) {
            return BALL;
        }
        return NOTHING;
    }

    private static boolean isStrike(int guessLocation, int location) {
        return guessLocation == location;
    }

    private static boolean isBall(int guessLocation, int location) {
        if (location == -1) {
            return false;
        }
        return guessLocation != location;
    }

}

