package baseball;

import static baseball.Numbers.LENGTH;

/**
 * 수비자 : 공격자가 입력한 숫자와 Numbers에서 뽑은 숫자를 비교하여
 *         볼, 스트라이크를 계산한다
 */
public class Defender {
    private int strikeCnt;
    private int ballCnt;

    Defender () {

    }

    private int findStrike(int[] numArr, int[] attackArr, int idx) {
        return numArr[idx] == attackArr[idx] ? 1 : 0;
    }

    private int findBall(int[] numArr, int[] attackArr, int idx) {
        int[] array = new int[LENGTH - 1];
        int index = 0;
        boolean isBall = false;

        for (int i = 0; i < LENGTH; i++) {
            array[index] = idx != i ? i : 0;
            index = idx != i ? index + 1 : index;
            i = index >= array.length ? LENGTH : i;
        }

        for (int i = 0; i < array.length; i++) {
            isBall = attackArr[idx] == numArr[array[i]];
            i = isBall ? array.length : i;
        }

        return isBall ? 1 : 0;
    }

    private int[] convertNumberToArray(int num) {
        int idx = LENGTH - 1;
        int[] array = new int[LENGTH];

        while (num > 0) {
            array[idx] = num % 10;
            num /= 10;
            idx--;
        }

        return array;
    }

    public void compare(int number, int attackNum) {
        int[] numArr = convertNumberToArray(number);
        int[] attackArr = convertNumberToArray(attackNum);

        int strikeTmp = 0;
        int ballTmp = 0;

        for (int i = 0; i < LENGTH; i++) {
            strikeTmp += findStrike(numArr, attackArr, i);
            ballTmp += findBall(numArr, attackArr, i);
        }

        strikeCnt = strikeTmp;
        ballCnt = ballTmp;
    }

    public boolean isAllStrike() {
        return  strikeCnt == LENGTH;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}