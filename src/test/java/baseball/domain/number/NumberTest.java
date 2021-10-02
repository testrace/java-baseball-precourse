package baseball.domain.number;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @ParameterizedTest(name = "숫자 객체 정상 범위 {index} [{arguments}]")
    @ValueSource(ints = {1,9})
    @DisplayName("숫자 객체 정상 범위")
    void construct(int value) {

        //when
        Number actual = new Number(value);

        //then
        assertThat(actual).isEqualTo(new Number(value));
    }

    @ParameterizedTest(name = "숫자 객체 비정상 범위 {index} [{arguments}]")
    @ValueSource(ints = {0,10})
    @DisplayName("숫자 객체 비정상 범위")
    void construct_exception(int value) {

        //when
        ThrowableAssert.ThrowingCallable actual = () -> new Number(value);

        //then
        assertThatThrownBy(actual).isInstanceOf(NumberException.class)
                .hasMessage("숫자의 유효범위는 1~9 입니다.");
    }

    @Test
    @DisplayName("숫자 객체 문자열 예외")
    void construct_string_exception() {

        //when
        ThrowableAssert.ThrowingCallable actual = () -> new Number("일");

        //then
        assertThatThrownBy(actual).isInstanceOf(NumberException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

}