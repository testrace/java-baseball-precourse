package baseball.controller;

import baseball.domain.baseball.BaseBall;
import baseball.domain.baseball.GuessResult;
import baseball.domain.baseball.NumberSelection;

public class BaseBallGame {

    private BaseBall baseball;
    private boolean end;

    public void start() {
        baseball = new BaseBall(NumberSelection.pick());
        end = false;
    }

    public GuessResult guess(String numbers) {
        GuessResult guess = baseball.guess(numbers);
        end = guess.isMaxStrike();
        return guess;
    }

    public boolean isPlaying() {
        return !isEnd();
    }

    public boolean isEnd() {
        return end;
    }

}
