package nextstep.utils;

import static baseball.Numbers.LENGTH;

public enum PrintType {
    NUMBER_INPUT("숫자를 입력해 주세요 : "),
    LENGTH_VERIFY("반드시 "+LENGTH+"자리 숫자를 입력해야 합니다."),
    DUPLICATE_VERIFY("중복되지 않은 숫자를 입력해야 합니다."),
    STRIKE_SIGN(" 스트라이크 "),
    BALL_SIGN(" 볼"),
    NOTHING_SIGN("낫싱"),
    GAME_END("아아아"),
    NEW_GAME("게임을 새로 시작하시려면 1, 끝내시려면 2를 눌러주세요");

    private final String msg;
    private Object etc;

    PrintType(String msg) {
        this.msg = msg;
        this.etc = null;
    }

    public String getMessage() {
        if(this == LENGTH_VERIFY) {
            return String.format(msg, etc);
        } else {
            return msg;
        }
    }
}
