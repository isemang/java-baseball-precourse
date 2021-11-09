package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 게임 시작 시 random한 숫자를 만들고, 저장하여 가지고 있는 객체
 * 객체 선언 시 자리수(length)를 받는다
 */
public class Numbers {
    private ArrayList<Integer> numList;

    Numbers(int length) {
        numList = new ArrayList<>();
        makeNumber(length);
    }

    public int size() {
        return numList.size();
    }

    public int[] getNumbers() {
        int[] array = new int[size()];

        for (int i = 0; i < size(); i++) {
            array[i] = numList.get(i);
        }

        return array;
    }

    private void makeNumber(int length) {
        HashSet<Integer> set = new HashSet<>();

        while(set.size() < length) {
            int randInt = Randoms.pickNumberInRange(1,9);
            set.add(randInt);
        }

        //항상 작은숫자가 앞자리에 나오는 걸 방지
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.shuffle(list);
        numList = list;
    }
}
