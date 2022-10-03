package baseball.ui;

import camp.nextstep.edu.missionutils.Console;
import java.io.PrintStream;

public class InputView {

    private static final PrintStream OUT = System.out;
    private static final String INPUT_NUMBERS = "숫자를 입력해 주세요 : ";
    private static final String CONTINUE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CONTINUE = "1";
    private static final String EXIT = "2";

    private InputView() {
        throw new AssertionError();
    }

    public static String inputNumbers() {
        OUT.print(INPUT_NUMBERS);
        return Console.readLine();
    }

    public static boolean continueGames() {
        String inputValue = inputContinueGame();
        if (validInputValue(inputValue)) {
            return inputValue.equals(CONTINUE);
        }

        throw new IllegalArgumentException();
    }

    private static String inputContinueGame() {
        OUT.println(CONTINUE_GAME);
        return Console.readLine();
    }

    private static boolean validInputValue(String continueGame) {
        return continueGame.equals(CONTINUE) || continueGame.equals(EXIT);
    }
}
