package baseball.domain.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballTest {

    @Test
    @DisplayName("객체 생성")
    void construct() {
        //given
        String numbers = "123";

        //when
        Baseball actual = new Baseball(numbers);

        //then
        assertThat(actual).isEqualTo(new Baseball(numbers));
    }

    @ParameterizedTest(name = "숫자 맞히기 결과 {index} [{arguments}]")
    @CsvSource(value = {
            "123,123,3,0",
            "123,321,1,2",
            "123,124,2,1",
            "123,451,0,1",
            "123,431,0,2",
            "123,231,0,3",
    })
    void guess(String numbers, String guessNumbers, int expectedStrike, int expectedBall) {
        //given
        Baseball baseball = new Baseball(numbers);
        GuessResult guessResult = baseball.guess(guessNumbers);

        //then
        int actualStrike = guessResult.strike();
        int actualBall = guessResult.ball();

        //then
        assertAll(
                () -> assertThat(actualStrike).isEqualTo(expectedStrike),
                () -> assertThat(actualBall).isEqualTo(expectedBall)
        );

    }

}