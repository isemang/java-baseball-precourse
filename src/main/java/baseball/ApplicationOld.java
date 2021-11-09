package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ApplicationOld {
    public static void main(String[] args) {
        int resumeGame = 1;

        while(resumeGame == 1) {
            int[] numbers = makeBaseballNumber();

            goStartGame(numbers);

            //또할건지 안할건지 물어보기
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

            resumeGame = checkResumeGameNumOk(sc.nextInt());
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static String ballAndStrike = "";
    private static int length = 3;

    private static int[] makeBaseballNumber() {
        int[] numbers = new int[length];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        for (int r = 0; r < length; r++) {
            numbers[r] = list.get(r);
        }

        return numbers;
    }

    private static void goStartGame(int[] numbers) {
        boolean isRight = false;

        while (!isRight) {
            //입력
            System.out.print("숫자를 입력해주세요 : ");
            int number = checkInputNumOk(sc.nextInt());
            int[] input = convertNumberToArray(number);

            //계산
            isRight = isAllStrike(input, numbers);

            //출력
            System.out.println(ballAndStrike);
        }
    }

    private static int[] convertNumberToArray(int num) {
        int idx = length - 1;
        int[] input = new int[length];

        while (num > 0) {
            input[idx] = num % 10;
            num /= 10;
            idx--;
        }

        return input;
    }

    private static boolean isAllStrike(int[] input, int[] numbers) {
        int strikeNum = 0;
        int ballNum = 0;

        for (int i = 0; i < length; i++) {
            strikeNum += findStrike(input, numbers, i);
            ballNum += findBall(input, numbers, i);
        }

        makeString(strikeNum, ballNum);

        return strikeNum == length;
    }

    private static int findStrike(int[] input, int[] numbers, int idx) {
        return numbers[idx] == input[idx] ? 1 : 0;
    }

    private static int findBall(int[] input, int[] numbers, int idx) {
        int[] array = new int[length - 1];
        int index = 0;
        boolean isBall = false;

        for (int i = 0; i < length; i++) {
            array[index] = idx != i ? i : 0;
            index = idx != i ? index + 1 : index;
            i = index >= array.length ? length : i;
        }

        for (int i = 0; i < array.length; i++) {
            isBall = numbers[idx] == input[array[i]];
            i = isBall ? array.length : i;
        }

        return isBall ? 1 : 0;
    }

    private static void makeString(int strikeNum, int ballNum) {
        StringBuilder sb = new StringBuilder();

        if (strikeNum > 0) {
            sb.append(strikeNum + " 스트라이크 ");
        }

        if (ballNum > 0) {
            sb.append(ballNum + " 볼");
        }

        if (strikeNum == 0 && ballNum == 0) {
            sb.append("낫싱");
        }

        ballAndStrike = sb.toString();
    }

    /**** input 값 exception 처리 ****/
    //게임 종료 시 1, 2가 아닌 다른 수를 입력했을 때
    private static int checkResumeGameNumOk(int resumeGame) {
        if (resumeGame == 1 || resumeGame == 2) {
            return resumeGame;
        }

        System.out.println("1 or 2만 입력이 가능합니다.");
        int num = sc.nextInt();
        return checkResumeGameNumOk(num);
    }

    //숫자 입력 시 선언된 length 값보다 긴 수를 입력했을 때
    private static int checkInputNumOk(int number) {
        if (Integer.toString(number).length() == length) {
            return number;
        }

        System.out.println(length + "자리의 수만 입력이 가능합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        int num = sc.nextInt();
        return checkInputNumOk(num);
    }

}
