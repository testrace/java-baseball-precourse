package baseball.ui;

import baseball.domain.baseball.GuessResult;

public class ResultView {
    public static void print(GuessResult guessResult) {
        if (guessResult.strike() != 0) {
            System.out.print(guessResult.strike() + "스트라이크");
        }
        if (guessResult.ball() != 0) {
            System.out.print(guessResult.ball() + "볼");
        }
        if (guessResult.strike() == 0 && guessResult.ball() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
