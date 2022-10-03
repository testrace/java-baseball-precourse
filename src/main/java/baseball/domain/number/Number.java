package baseball.domain.number;

import java.util.Objects;

public class Number {

    public static final int MIN = 1;
    public static final int MAX = 9;

    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number from(int value) {
        return NumberCache.from(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static class NumberCache {

        static final Number[] CACHE_NUMBERS;

        static {
            CACHE_NUMBERS = new Number[MAX + 1];
            initialize();
        }

        static void initialize() {
            for (int i = MIN; i <= MAX; i++) {
                CACHE_NUMBERS[i] = new Number(i);
            }
        }

        static Number from(int value) {
            validateRange(value);
            return CACHE_NUMBERS[value];
        }

        static void validateRange(int value) {
            if (value < MIN || value > MAX) {
                throw new IllegalArgumentException("숫자의 정상 범위는 1에서 9입니다. 예외 숫자: " + value);
            }
        }
    }
}
