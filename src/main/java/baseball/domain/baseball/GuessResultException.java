package baseball.domain.baseball;

public class GuessResultException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "스트라이크 또는 볼은 0~3 사이의 숫자만 가능합니다. 현재 값 : %d";

    public GuessResultException(int value) {
        super(String.format(DEFAULT_MESSAGE, value));
    }

}
