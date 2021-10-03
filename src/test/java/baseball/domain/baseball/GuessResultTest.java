package baseball.domain.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
        GuessResult guessResult = new GuessResult();
        guessResult = guessResult.addResult(GuessState.STRIKE);

        //when
        int actual = guessResult.strike();

        //then
        assertThat(actual).isEqualTo(1);

    }

    @Test
    @DisplayName("볼")
    void ball() {
        //given
        GuessResult guessResult = new GuessResult();
        guessResult = guessResult.addResult(GuessState.BALL);

        //when
        int actual = guessResult.ball();

        //then
        assertThat(actual).isEqualTo(1);

    }

    @Test
    @DisplayName("스트라이크와 볼")
    void strike_ball() {
        //given
        GuessResult guessResult = new GuessResult();
        guessResult = guessResult.addResult(GuessState.STRIKE);
        guessResult = guessResult.addResult(GuessState.BALL);

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

}