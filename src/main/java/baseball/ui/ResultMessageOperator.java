package baseball.ui;

import baseball.domain.baseball.GuessResult;

@FunctionalInterface
public interface ResultMessageOperator {
    boolean apply(GuessResult guessResult);
}
