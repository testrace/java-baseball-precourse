package baseball.domain;

import java.util.EnumMap;
import java.util.Map;

public class GuessScore {

    private static final int UNIT_OF_INCREASE = 1;
    private static final int DEFAULT_SCORE = 0;
    private static final int COUNT_OF_NUMBERS = 3;

    private final Map<GuessState, Integer> scores = new EnumMap<>(GuessState.class);

    public void addScore(GuessState state) {
        if (state != GuessState.NOTHING) {
            scores.merge(state, UNIT_OF_INCREASE, (key, value) -> scores.get(state) + UNIT_OF_INCREASE);
        }
    }

    public int getScore(GuessState guessState) {
        return scores.getOrDefault(guessState, DEFAULT_SCORE);
    }

    public boolean isGameOver() {
        return getScore(GuessState.STRIKE) >= COUNT_OF_NUMBERS;
    }
}
