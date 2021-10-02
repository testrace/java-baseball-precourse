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
