package baseball.domain.baseball;

import baseball.domain.number.Numbers;

import java.util.Objects;

public class BaseBall {

    private static final String STRING_DELIMITER = "";

    private final Numbers numbers;

    public BaseBall(Numbers numbers) {
        this.numbers = numbers;
    }

    public BaseBall(String numbers) {
        this(Numbers.of(numbers));
    }

    public GuessResult guess(String guessNumbers) {
        validateGuessNumber(guessNumbers);
        return calculateResult(guessNumbers);
    }

    private void validateGuessNumber(String guessNumbers) {
        Numbers.of(guessNumbers);
    }

    private GuessResult calculateResult(String guessNumbers) {
        return calculateResult(guessNumbers.split(STRING_DELIMITER));
    }

    private GuessResult calculateResult(String[] guessNumbers) {
        GuessResult guessResult = new GuessResult();
        for (int i = 0; i < guessNumbers.length; i++) {
            int location = numbers.location(guessNumbers[i]);
            guessResult = guessResult.addResult(GuessState.of(i, location));
        }
        return guessResult;
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
