package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NumberFactoryTest {

    @ParameterizedTest(name = "빈값으로 Numbers 일급 컬렉션을 생성할 수 없다. {0}")
    @NullAndEmptySource
    void cannotCreateByNull(String inputValue) {
        assertThatThrownBy(() -> NumberFactory.convert(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "빈 컬렉션으로 Numbers 일급 컬렉션을 생성할 수 없다. {0}")
    @NullAndEmptySource
    void cannotCreateByEmptyCollection(List<Integer> inputValues) {
        assertThatThrownBy(() -> NumberFactory.convert(inputValues))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 숫자로 Numbers를 생성할 수 없다")
    @Test
    void cannotCreateByDuplicatedNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        assertThatThrownBy(() -> NumberFactory.convert(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
