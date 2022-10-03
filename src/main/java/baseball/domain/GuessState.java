package baseball.domain;

import baseball.domain.number.LocationNumber;
import baseball.domain.number.Numbers;
import java.util.function.BiPredicate;

public enum GuessState {

    BALL(Numbers::hasSameNumber),
    STRIKE(Numbers::contains),
    NOTHING((numbers, locationNumber) -> false);

    private final BiPredicate<Numbers, LocationNumber> predicate;

    GuessState(BiPredicate<Numbers, LocationNumber> predicate) {
        this.predicate = predicate;
    }

    public static GuessState of(Numbers numbers, LocationNumber locationNumber) {
        if (isStrike(numbers, locationNumber)) {
            return STRIKE;
        }
        return nonStrikeState(numbers, locationNumber);
    }

    private static GuessState nonStrikeState(Numbers numbers, LocationNumber locationNumber) {
        if (isBall(numbers, locationNumber)) {
            return BALL;
        }
        return NOTHING;
    }

    private static boolean isStrike(Numbers numbers, LocationNumber locationNumber) {
        return STRIKE.predicate.test(numbers, locationNumber);
    }

    private static boolean isBall(Numbers numbers, LocationNumber locationNumber) {
        return BALL.predicate.test(numbers, locationNumber);
    }

}
