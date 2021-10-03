package baseball.ui;

import baseball.domain.baseball.GuessResult;

public class ResultView {

    public static void print(GuessResult guessResult) {
        ResultMessage resultMessage = ResultMessage.of(guessResult);
        System.out.println(resultMessage.message(guessResult));
    }

}
