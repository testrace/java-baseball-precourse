package baseball.domain.number;

public class NumberRangeException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "숫자의 유효범위는 1~9 입니다.";

    public NumberRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
