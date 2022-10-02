package baseball.domain.number;

public class Number {

    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number from(int value) {
        return NumberCache.from(value);
    }

    private static class NumberCache {

        static final int MIN = 1;
        static final int MAX = 9;
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
