package baseball.domain.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GuessStateTest {

    @Test
    @DisplayName("스트라이크 - 추측한 숫자의 위치와 컴퓨터의 숫자 위치가 동일")
    void strike() throws Exception {
        //given
        int guessLocation = 1;
        int location = 1;

        //when
        GuessState actual = GuessState.of(guessLocation, location);


        //then
        assertThat(actual).isEqualTo(GuessState.STRIKE);
    }

    @Test
    @DisplayName("볼 - 추측한 숫자가 컴퓨터의 숫자에 존재하지만 위치가 다름")
    void ball() throws Exception {
        //given
        int guessLocation = 1;
        int location = 2;

        //when
        GuessState actual = GuessState.of(guessLocation, location);


        //then
        assertThat(actual).isEqualTo(GuessState.BALL);
    }

    @Test
    @DisplayName("낫싱 - 추측한 숫자가 컴퓨터의 숫자에 없음")
    void nothing() throws Exception {
        //given
        int guessLocation = 1;
        int location = -1;

        //when
        GuessState actual = GuessState.of(guessLocation, location);


        //then
        assertThat(actual).isEqualTo(GuessState.NOTHING);
    }

}