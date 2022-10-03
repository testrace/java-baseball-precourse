package baseball.ui;

import baseball.application.dto.GuessResult;
import java.io.PrintStream;

public class ResultView {

    private static final PrintStream OUT = System.out;
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printScore(GuessResult guessResult) {
        OUT.println(ResultMessage.from(guessResult));
    }

    public static void printGameOver() {
        OUT.println(GAME_OVER_MESSAGE);
    }

}
