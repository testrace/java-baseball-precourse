package baseball.application.dto;

public class GuessResult {

    private int ball;
    private int strike;
    private boolean gameOver;

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public boolean hasBallAndStrike() {
        return hasBall() && hasStrike();
    }

}
