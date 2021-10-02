package baseball.domain.number;

import java.util.*;

public class Numbers {

    private static final int SIZE = 3;
    private static final String STRING_DELIMITER = "";

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        if (numbers.size() != SIZE) {
            throw new NumbersException("숫자 3개만 생성 가능합니다.");
        }
    }

    public static Numbers of(String numbers) {
        validateLength(numbers);
        String[] split = numbers.split(STRING_DELIMITER);
        validateDuplication(split);
        return new Numbers(toList(split));
    }

    private static List<Number> toList(String[] split) {
        List<Number> list = new ArrayList<>();
        for (String number : split) {
            list.add(new Number(number));
        }
        return list;
    }

    private static void validateLength(String numbers) {
        if (numbers == null || numbers.length() != SIZE) {
            throw new NumbersException("숫자 3개만 생성 가능합니다.");
        }
    }

    private static void validateDuplication(String[] split) {
        Set<String> duplicate = new LinkedHashSet<>(Arrays.asList(split));
        if (split.length != duplicate.size()) {
            throw new NumbersException("중복된 숫자로 생성할 수 없습니다.");
        }
    }

    public int position(int number) {
        return numbers.indexOf(new Number(number));
    }

    public List<Number> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
