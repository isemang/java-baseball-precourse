package baseball;

import nextstep.utils.Randoms;

import java.util.*;

/**
 * 게임 시작 시 random한 숫자를 만들고, 저장하여 가지고 있는 객체
 * 객체 선언 시 자리수(length)를 받는다
 */
public class Numbers {
    public static final int LENGTH = 3;
    private List<Integer> numList;

    Numbers() {
        numList = new ArrayList<>();
        makeNumber();
    }

    public int[] getNumbers() {
        int[] array = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            array[i] = numList.get(i);
        }

        return array;
    }

    private void makeNumber() {
        Set<Integer> set = new HashSet<>();

        while(set.size() < LENGTH) {
            int randInt = Randoms.pickNumberInRange(1,9);
            set.add(randInt);
        }

        //항상 작은숫자가 앞자리에 나오는 걸 방지
        List<Integer> list = new ArrayList<>(set);
        Collections.shuffle(list);
        numList = list;
    }
}
