package baseball.domain.number;

import java.util.Objects;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final String WRONG_NUMBER_MESSAGE = "숫자만 입력 가능합니다.";

    private final int value;

    public Number(int value) {
        validate(value);
        this.value = value;
    }

    public Number(String value) {
        this(parseInt(value));
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new NumberException(WRONG_NUMBER_MESSAGE);
        }
    }

    private void validate(int value) {
        if (!isValid(value)) {
            throw new NumberException();
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
