package baseball.domain.baseball;

import baseball.domain.number.Number;
import baseball.domain.number.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberSelectionTest {

    @Test
    @DisplayName("랜덤 번호 3개 생성")
    void select() {
        //given
        Numbers numbers = NumberSelection.pick();

        //when
        List<Number> actual = numbers.numbers();

        //then
        assertThat(actual).hasSize(3);
    }

    @Test
    @DisplayName("랜덤 번호 생성 중복 없음")
    void select_not_duplication() {
        //given
        Numbers numbers = NumberSelection.pick();

        //when
        List<Number> actual = numbers.numbers();
        int expected = new HashSet<>(actual).size();

        //then
        assertThat(actual).hasSize(expected);
    }

}