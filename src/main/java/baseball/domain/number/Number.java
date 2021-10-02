package baseball.domain.number;

import java.util.Objects;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 9;

    private final int value;

    public Number(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (!isValid(value)) {
            throw new NumberRangeException();
        }
    }

    private boolean isValid(int value) {
        return isGraterThanOrEqual(value) && isLessThanOrEqual(value);
    }

    private boolean isGraterThanOrEqual(int value) {
        return value >= MIN;
    }

    private boolean isLessThanOrEqual(int value) {
        return value <= MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
