package baseball.domain.baseball;

import baseball.domain.number.Number;
import baseball.domain.number.Numbers;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberSelection {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int NUMBERS_LENGTH = 3;

    private NumberSelection() {
        throw new IllegalStateException();
    }

    public static Numbers pick() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < NUMBERS_LENGTH) {
            int selectedNumber = Randoms.pickNumberInRange(MIN, MAX);
            addNumber(selectedNumber, numbers);
        }
        return new Numbers(numbers);
    }

    private static void addNumber(int selectedNumber, List<Number> numbers) {
        Number number = new Number(selectedNumber);
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

}
