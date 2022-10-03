package baseball.domain.number;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LocationNumberTest {

    @DisplayName("특정 위치의 숫자")
    @Test
    void locationNumber() {
        LocationNumber actual = new LocationNumber(Location.FIRST, Number.from(1));

        assertThat(actual).isEqualTo(new LocationNumber(Location.FIRST, Number.from(1)));
    }

    @DisplayName("같은 숫자를 가지는지 확인할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, false"
    })
    void matchLocationWithNumber(int number, boolean expected) {
        LocationNumber locationNumber = new LocationNumber(Location.FIRST, Number.from(1));
        LocationNumber guessLocationNumber = new LocationNumber(Location.SECOND, Number.from(number));

        boolean actual = locationNumber.matchOnlyNumber(guessLocationNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "null 또는 빈값으로 생성할 수 없다. {0}, {1}")
    @MethodSource
    void nullOrEmptyException(Location location, Number number) {
        assertThatThrownBy(() -> new LocationNumber(location, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> nullOrEmptyException() {
        return Stream.of(
            Arguments.of(Location.FIRST, null),
            Arguments.of(null, Number.from(1))
        );
    }
    
    @DisplayName("동등성 비교")
    @Test
    void equals() {
        LocationNumber locationNumber = new LocationNumber(Location.FIRST, Number.from(1));
        
        assertThat(locationNumber).isEqualTo(locationNumber);
        
    }

    @DisplayName("동등성 비교")
    @Test
    void notEquals() {
        LocationNumber locationNumber = new LocationNumber(Location.FIRST, Number.from(1));

        assertThat(locationNumber).isNotEqualTo(Number.from(1));

    }

}
