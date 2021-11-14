package nextstep.utils;

import baseball.Result;

import static baseball.Numbers.LENGTH;

public class CountUtil {
    private static int strikeCnt = 0;
    private static int ballCnt = 0;

    public static Result compare(String number, String attackNum) {
        initializeCnt();

        for (int i = 0; i < LENGTH; i++) {
            String str = Character.toString(number.charAt(i));

            strikeOrBall(attackNum, str, i);
        }

        return new Result(strikeCnt, ballCnt);
    }

    private static void initializeCnt() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    private static void strikeOrBall(String attackNum, String str, int i) {
        if (attackNum.contains(str)) {
            int idx = attackNum.indexOf(str);

            updateCnt(i, idx);
        }
    }

    private static void updateCnt(int i, int idx) {
        if(i == idx) {
            strikeCnt++;
            return;
        }
        ballCnt++;
    }
}
