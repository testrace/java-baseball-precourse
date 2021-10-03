package baseball.ui;

import nextstep.utils.Console;

public class InputView {

    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CONTINUE_GAME_WRONG = "잘못 입력하셨습니다 다시 입력해주세요. ";
    private static final String CONTINUE = "1";
    private static final String EXIT = "2";

    public static String inputNumbers() {
        System.out.print(INPUT_NUMBERS);
        return Console.readLine();
    }

    public static boolean continueGame() {
        System.out.println(CONTINUE_GAME);
        String continueGame = Console.readLine();
        if (!continueGame.equals(CONTINUE) && !continueGame.equals(EXIT)) {
            System.out.print(CONTINUE_GAME_WRONG);
            return continueGame();
        }
        return continueGame.equals(CONTINUE);
    }

}
