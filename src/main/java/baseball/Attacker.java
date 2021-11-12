package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static baseball.Numbers.LENGTH;

/**
 * 공격자 : 공격하는 숫자를 입력받고 저장한다
 */
public class Attacker {
    private int attackNum;
    private Scanner sc = new Scanner(System.in);

    Attacker () {
        setAttackNum();
        while(!setAttackNumPassed()) setAttackNum();
        sc.close();
    }

    private boolean setAttackNumPassed() {
        if(attackNumSize() != LENGTH) {
            System.out.println("반드시 "+LENGTH+"자리 숫자를 입력해야 합니다.");
            return false;
        }

        if(isDuplicated()) {
            System.out.println("중복되지 않은 숫자를 입력해야 합니다.");
            return false;
        }

        return true;
    }

    private boolean isDuplicated() {
        Set<Integer> set = new HashSet<>();

        for(String str : Integer.toString(attackNum).split("")) {
            int num = Integer.parseInt(str);
            set.add(num);
        }

        if(set.size() == LENGTH) return false;
        return true;
    }

    private void setAttackNum() {
        System.out.print("숫자를 입력하세요 : ");
        attackNum = sc.nextInt();
    }

    public int getAttackNum(){
        return attackNum;
    }

    public int attackNumSize() {
        return Integer.toString(attackNum).split("").length;
    }
}