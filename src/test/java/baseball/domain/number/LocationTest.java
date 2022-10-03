package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LocationTest {

    @ParameterizedTest(name = "숫자의 위치를 지정한다 {0}, {1}")
    @MethodSource
    void location(int value, Location expected) {
        Location actual = Location.from(value);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> location() {
        return Stream.of(
                Arguments.of(1, Location.FIRST),
                Arguments.of(2, Location.SECOND),
                Arguments.of(3, Location.THIRD)
        );
    }

    @ParameterizedTest(name = "범위를 벗어난 위치를 지정하면 예외가 발생한다. {0}")
    @ValueSource(ints = {0, 4})
    void invalidLocationRange(int value) {
        assertThatThrownBy(() -> Location.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치는 1, 2, 3 중 하나만 가능합니다. 현재 위치: " + value);
    }
}
