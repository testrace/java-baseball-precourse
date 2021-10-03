package baseball.domain.baseball;

import baseball.domain.number.Numbers;
import baseball.domain.number.NumbersException;

import java.util.Objects;

public class BaseBall {

    private final Numbers numbers;

    public BaseBall(Numbers numbers) {
        this.numbers = numbers;
    }

    public BaseBall(String numbers) {
        this(Numbers.of(numbers));
    }

    public GuessResult guess(String guessNumbers) throws NumbersException {
        validateGuessNumber(guessNumbers);
        GuessResult guessResult = new GuessResult();
        String[] strings = guessNumbers.split("");
        for (int i = 0; i < strings.length; i++) {
            int location = numbers.location(strings[i]);
            guessResult = guessResult.addResult(GuessState.of(i, location));
        }
        return guessResult;
    }

    private void validateGuessNumber(String guessNumbers) throws NumbersException {
        Numbers.of(guessNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBall baseball = (BaseBall) o;
        return Objects.equals(numbers, baseball.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
