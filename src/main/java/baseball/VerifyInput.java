package baseball;

import nextstep.utils.PrintStrings;
import nextstep.utils.Printer;

import java.util.*;

import static baseball.Numbers.LENGTH;

/**
 * 입력받은 숫자를 검증한다
 * 검증할 부분
 * 1) LENGTH자리 숫자를 입력했는지
 * 2) 중복된 숫자를 입력하지 않았는지
 */
public class VerifyInput {
    private VerifyInput() {
    }

    public static boolean restrictionsPassed(int attackNum) {
        if(attackNumSize(attackNum) != LENGTH) {
            Printer.print(PrintStrings.LENGTH_VERIFY);
            return false;
        }

        if(isDuplicated(attackNum)) {
            Printer.print(PrintStrings.DUPLICATE_VERIFY);
            return false;
        }

        return true;
    }

    private static boolean isDuplicated(int attackNum) {
        boolean isDuplicated = true;
        Set<Integer> set = new HashSet<>();

        for(String str : Integer.toString(attackNum).split("")) {
            int num = Integer.parseInt(str);
            set.add(num);
        }

        if(set.size() == LENGTH) {
            isDuplicated = false;
        }

        return isDuplicated;
    }

    private static int attackNumSize(int attackNum) {
        return (int) Math.log10(attackNum) + 1;
    }
}