package baseball.domain.number;

public class NumberException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "숫자의 유효범위는 1~9 입니다.";

    public NumberException() {
        super(DEFAULT_MESSAGE);
    }

    public NumberException(String message) {
        super(message);
    }
}
