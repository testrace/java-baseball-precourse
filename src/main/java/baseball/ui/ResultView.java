package baseball.ui;

import baseball.domain.baseball.GuessResult;

public class ResultView {

    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    public static void print(GuessResult guessResult) {
        ResultMessage resultMessage = ResultMessage.of(guessResult);
        System.out.println(resultMessage.message(guessResult));
        if (guessResult.isMaxStrike()) {
            System.out.println(GAME_OVER_MESSAGE);
        }
    }

}
