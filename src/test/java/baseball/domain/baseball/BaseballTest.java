package baseball.domain.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}