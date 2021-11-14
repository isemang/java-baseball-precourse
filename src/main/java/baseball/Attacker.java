package baseball;

import java.util.*;

import static baseball.Numbers.LENGTH;

/**
 * 공격자 : 공격하는 숫자를 입력받고 저장한다
 */
public class Attacker {
    private int attackNum;
    private Scanner sc = new Scanner(System.in);

    Attacker () {
        inputAttackNum();
        while(!restrictionsPassed()) inputAttackNum();
        sc.close();
    }

    private boolean restrictionsPassed() {
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

    private void inputAttackNum() {
        System.out.print("숫자를 입력하세요 : ");
        attackNum = sc.nextInt();
    }

    public String getAttackNum(){
        return Integer.toString(attackNum);
    }

    public int attackNumSize() {
        return (int) Math.log10(attackNum) + 1;
    }
}