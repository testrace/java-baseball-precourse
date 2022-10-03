package baseball.domain.number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NumberFactory {

    private NumberFactory() {
        throw new AssertionError();
    }

    public static Numbers convert(String numbers) {
        validate(numbers);
        String[] split = numbers.split("");
        List<Integer> converted = new ArrayList<>();
        for (String s : split) {
            converted.add(Integer.parseInt(s));
        }

        return convert(converted);
    }

    private static void validate(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static Numbers convert(List<Integer> numbers) {
        validate(numbers);
        Set<LocationNumber> locationNumbers = new LinkedHashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            Location location = Location.from(i + 1);
            Number number = Number.from(numbers.get(i));
            locationNumbers.add(new LocationNumber(location, number));
        }
        return new Numbers(locationNumbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
