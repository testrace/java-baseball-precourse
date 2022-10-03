package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessScoreTest {

    @DisplayName("스트라이크 추가")
    @Test
    void addStrike() {
        GuessScore guessScore = new GuessScore();

        guessScore.addScore(GuessState.STRIKE);

        int actual = guessScore.getScore(GuessState.STRIKE);

        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("볼 추가")
    @Test
    void addBall() {
        GuessScore guessScore = new GuessScore();

        guessScore.addScore(GuessState.BALL);

        int actual = guessScore.getScore(GuessState.BALL);

        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("게임이 종료를 확인할 수 있다")
    @Test
    void gameOver() {
        GuessScore guessScore = new GuessScore();

        guessScore.addScore(GuessState.STRIKE);
        guessScore.addScore(GuessState.STRIKE);
        guessScore.addScore(GuessState.STRIKE);

        boolean actual = guessScore.isGameOver();

        assertThat(actual).isTrue();
    }

}
