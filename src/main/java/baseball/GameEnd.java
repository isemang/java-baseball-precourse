package baseball;

import static baseball.Numbers.LENGTH;

public class GameEnd {
    private GameEnd() {
    }

    public static boolean isGameEnded(int strike, int ball) {
        boolean isGameEnded = false;

        if (strike == LENGTH && ball == 0) {
            isGameEnded = true;
        }

        return isGameEnded;
    }
}
