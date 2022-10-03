package baseball.application;

import baseball.domain.number.Number;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberSelector {

    public List<Integer> select(final int countOfNumbers, NumberPicker numberPicker) {
        Set<Integer> pickNumberInRange = new HashSet<>();
        while (pickNumberInRange.size() != countOfNumbers) {
            pickNumberInRange.add(numberPicker.pickNumberInRange(Number.MIN, Number.MAX));
        }
        return new ArrayList<>(pickNumberInRange);
    }
}
