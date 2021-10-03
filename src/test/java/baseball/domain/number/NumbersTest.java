package baseball.domain.number;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @Test
    @DisplayName("Number 일급 컬렉션 생성")
    void construct() {
        //given
        String values = "123";

        //when
        Numbers actual = Numbers.of(values);

        //then
        assertThat(actual).isEqualTo(Numbers.of("123"));
    }

    @ParameterizedTest(name = "객체 생성 숫자 개수 예외 {index} [{arguments}]")
    @ValueSource(strings = {
            "",
            "12",
            "1234"
    })
    @DisplayName("객체 생성 숫자 개수 예외")
    void construct_exception(String numbers) {
        //when
        ThrowableAssert.ThrowingCallable actual = () -> Numbers.of(numbers);

        //then
        assertThatThrownBy(actual).isInstanceOf(NumbersException.class)
                .hasMessage("숫자 3개만 생성 가능합니다.");
    }

    @ParameterizedTest(name = "객체 생성 중복 숫자 예외 {index} [{arguments}]")
    @ValueSource(strings = {
            "111",
            "112",
            "122",
            "121"
    })
    void construct_duplicate_number_exception(String numbers) {
        //when
        ThrowableAssert.ThrowingCallable actual = () -> Numbers.of(numbers);

        //then
        assertThatThrownBy(actual).isInstanceOf(NumbersException.class)
                .hasMessage("중복된 숫자로 생성할 수 없습니다.");
    }

    @ParameterizedTest(name = "숫자의 위치 {index} [{arguments}]")
    @CsvSource(value = {
            "123,1,0",
            "123,2,1",
            "123,4,-1",
    })
    void location(String numbers, String number, int expected) {
        //when
        int actual = Numbers.of(numbers)
                .location(number);

        //then
        assertThat(actual).isEqualTo(expected);
    }

}