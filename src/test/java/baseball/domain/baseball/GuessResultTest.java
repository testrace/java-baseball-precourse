package baseball.domain.baseball;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class GuessResultTest {

    @Test
    @DisplayName("낫싱")
    void nothing() {
        //given
        GuessResult guessResult = new GuessResult();

        //when
        boolean actual = guessResult.isNothing();

        //then
        assertThat(actual).isTrue();

    }

    @Test
    @DisplayName("스트라이크")
    void strike() {
        //given
        GuessResult guessResult = new GuessResult()
                .addResult(GuessState.STRIKE);

        //when
        int actual = guessResult.strike();

        //then
        assertThat(actual).isEqualTo(1);

    }

    @Test
    @DisplayName("볼")
    void ball() {
        //given
        GuessResult guessResult = new GuessResult()
                .addResult(GuessState.BALL);

        //when
        int actual = guessResult.ball();

        //then
        assertThat(actual).isEqualTo(1);

    }

    @Test
    @DisplayName("스트라이크와 볼")
    void strike_ball() {
        //given
        GuessResult guessResult = new GuessResult()
                .addResult(GuessState.STRIKE)
                .addResult(GuessState.BALL);

        //when
        int actualStrike = guessResult.strike();
        int actualBall = guessResult.ball();
        boolean actualNothing = guessResult.isNothing();

        //then
        assertAll(
                () -> assertThat(actualStrike).isEqualTo(1),
                () -> assertThat(actualBall).isEqualTo(1),
                () -> assertThat(actualNothing).isFalse()
        );

    }

    @Test
    @DisplayName("결과 생성 예외")
    void exception() {
        //given
        GuessResult guessResult = new GuessResult()
                .addResult(GuessState.STRIKE)
                .addResult(GuessState.STRIKE)
                .addResult(GuessState.STRIKE);


        //when
        ThrowableAssert.ThrowingCallable actual = () -> guessResult.addResult(GuessState.STRIKE);

        //then
        assertThatThrownBy(actual).isInstanceOf(GuessResultException.class)
                .hasMessage("스트라이크 또는 볼은 0~3 사이의 숫자만 가능합니다. 현재 값 : 4");

    }

}