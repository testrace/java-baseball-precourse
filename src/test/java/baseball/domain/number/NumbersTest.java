package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NumbersTest {

    @ParameterizedTest(name = "null 또는 빈 값으로 초기화할 수 없다 {0}")
    @NullAndEmptySource
    void cannotInitialize(Set<LocationNumber> numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값으로 초기화할 수 없습니다.");
    }

    @ParameterizedTest(name = "위치와 숫자가 일치하는 요소를 가지는지 확인할 수 있다, {0}")
    @CsvSource(value = {
            "1, true",
            "4, false"
    })
    void contains(int number, boolean expected) {
        Numbers numbers = createMockNumbers();
        LocationNumber locationNumber = new LocationNumber(Location.FIRST, Number.from(number));

        boolean actual = numbers.contains(locationNumber);

        assertThat(actual).isEqualTo(expected);
    }

    private Numbers createMockNumbers() {
        LocationNumber one = new LocationNumber(Location.FIRST, Number.from(1));
        LocationNumber two = new LocationNumber(Location.SECOND, Number.from(2));
        LocationNumber three = new LocationNumber(Location.THIRD, Number.from(3));
        Set<LocationNumber> locationNumbers = new HashSet<>(Arrays.asList(one, two, three));

        return new Numbers(locationNumbers);
    }

    @ParameterizedTest(name = "위치와 상관없이 숫자가 일치하는 요소를 가지는지 확인할 수 있다, {0}")
    @CsvSource(value = {
            "1, true",
            "4, false"
    })
    void hasSameNumber(int number, boolean expected) {
        Numbers numbers = createMockNumbers();
        LocationNumber locationNumber = new LocationNumber(Location.THIRD, Number.from(number));

        boolean actual = numbers.hasSameNumber(locationNumber);

        assertThat(actual).isEqualTo(expected);
    }
}
