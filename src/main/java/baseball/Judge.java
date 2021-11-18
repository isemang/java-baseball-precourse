package baseball;

import static baseball.Numbers.LENGTH;

public class Judge {
    private static int strikeCount = 0;
    private static int ballCount = 0;

    private Judge() {
    }

    public static Result compare(String number, String attackNum) {
        initializeCount();

        for (int i = 0; i < LENGTH; i++) {
            String str = Character.toString(number.charAt(i));

            strikeOrBall(attackNum, str, i);
        }

        return new Result(strikeCount, ballCount);
    }

    private static void initializeCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private static void strikeOrBall(String attackNum, String str, int i) {
        if (attackNum.contains(str)) {
            int index = attackNum.indexOf(str);

            updateCount(i, index);
        }
    }

    private static void updateCount(int i, int index) {
        if (i == index) {
            strikeCount++;
            return;
        }
        ballCount++;
    }
}
