package baseball.domain.baseball;

@FunctionalInterface
public interface GuessStateOperator {

    boolean guess(int number, int location);

}
