package baseball.domain.baseball;

import baseball.domain.number.Numbers;

import java.util.Objects;

public class Baseball {

    private final Numbers numbers;

    public Baseball(Numbers numbers) {
        this.numbers = numbers;
    }

    public Baseball(String numbers) {
        this(Numbers.of(numbers));
    }

    public GuessResult guess(String guessNumbers) {
        GuessResult guessResult = new GuessResult();
        String[] strings = guessNumbers.split("");
        for (int i = 0; i < strings.length; i++) {
            int location = numbers.location(strings[i]);
            guessResult = guessResult.addResult(GuessState.of(i, location));
        }
        return guessResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return Objects.equals(numbers, baseball.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
