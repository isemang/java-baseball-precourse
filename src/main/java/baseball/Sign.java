package baseball;

/**
 * 전광판 : defender(수비자)의 계산결과를 나타내줌
 */
public class Sign {
    private final String strikeStr = " 스트라이크 ";
    private final String ballStr = " 볼";
    private final String nothing = "낫싱";
    private String showResult = "";

    Sign(int strike, int ball) {
        makeSign(strike, ball);
    }

    private void makeSign(int strike, int ball) {
        StringBuilder resultStr = new StringBuilder();

        if (strike > 0) resultStr.append(strike + strikeStr);
        if (ball > 0) resultStr.append(ball + ballStr);

        if(resultStr.length() == 0) resultStr.append(nothing);

        showResult = resultStr.toString();
    }

    public String showResult() {
        return showResult;
    }
}