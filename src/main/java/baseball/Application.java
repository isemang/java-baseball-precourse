package baseball;

import nextstep.utils.PrintType;
import nextstep.utils.Printer;
import nextstep.utils.Scan;

public class Application {
    public static void main(String[] args) {
        int newGameOrNot = 1;
        int attackNum = 0;

        boolean restrictionsPassed = false;

        Scan scan = new Scan();
        Numbers numbers;
        Result result;

        while(newGameOrNot == 1) {
            numbers = new Numbers();
            String randomNum = numbers.getNumbers();
            int strike = 0;
            int ball = 0;

            while(!GameEnd.isGameEnded(strike, ball)) {
                while(!restrictionsPassed) {
                    Printer.print(PrintType.NUMBER_INPUT);
                    attackNum = scan.scanValue();

                    restrictionsPassed = VerifyInput.restrictionsPassed(attackNum);
                }

                result = Judge.compare(randomNum, Integer.toString(attackNum));
                strike = result.getStrikeCnt();
                ball = result.getBallCnt();

                String resultString = result.makeBaseballResult(strike, ball);

                Printer.println(resultString);

                restrictionsPassed = false;
            }

            Printer.println(PrintType.GAME_END);
            Printer.println(PrintType.NEW_GAME);
            newGameOrNot = scan.scanValue();
        }

        scan.closeScan();
    }
}
