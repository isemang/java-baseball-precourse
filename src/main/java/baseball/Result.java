package baseball;

import nextstep.utils.PrintType;

import static baseball.Numbers.LENGTH;

public class Result {
    private int strikeCnt;
    private int ballCnt;

    public Result(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public String makeBaseballResult(int strike, int ball) {
        StringBuilder resultStr = new StringBuilder();

        if (strike > 0) {
            resultStr.append(strike);
            resultStr.append(PrintType.STRIKE_SIGN);
        }
        if (ball > 0) {
            resultStr.append(ball);
            resultStr.append(PrintType.BALL_SIGN);
        }

        if (strike == LENGTH) resultStr.append(PrintType.GAME_END);

        if (resultStr.length() == 0) resultStr.append(PrintType.NOTHING_SIGN);

        return resultStr.toString();
    }
}
