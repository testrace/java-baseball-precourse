package baseball.ui;

import nextstep.utils.Console;

public class InputView {
    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 : ";


    public static String inputNumbers() {
        System.out.print(INPUT_NUMBERS);
        return Console.readLine();
    }

}
