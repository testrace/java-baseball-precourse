package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest(name = "캐시된 숫자 객체 생성: {0}")
    @ValueSource(ints = {1, 9})
    void create(int value) {
        Number actual = Number.from(value);

        assertThat(actual).isSameAs(Number.from(value));
    }

    @ParameterizedTest(name = "숫자 객체의 범위가 벗어난 경우 예외 발생: {0}")
    @ValueSource(ints = {0, 10})
    void rangeException(int value) {
        ThrowingCallable throwingCallable = () -> Number.from(value);

        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }
}
