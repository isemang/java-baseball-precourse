package baseball;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static baseball.Numbers.LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NSTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 랜덤으로_3자리_숫자를_뽑는다() {
        Numbers numbers = new Numbers();
        String num = numbers.getNumbers();
        assertThat(num.length()).isEqualTo(LENGTH);
    }

    @Test
    void 입력받은_3자리_숫자가_중복되지_않는지_확인_성공() {
        boolean result = VerifyInput.restrictionsPassed(123);
        assertThat(result).isTrue();
    }

    @Test
    void 입력받은_숫자가_네자리이면_실패() {
        boolean result = VerifyInput.restrictionsPassed(1423);
        assertThat(result).isFalse();
    }

    @Test
    void 입력받은_세자리_숫자에_중복되는_숫자가_있으면_실패() {
        boolean result = VerifyInput.restrictionsPassed(222);
        assertThat(result).isFalse();
    }

    @Test
    void 두_숫자_비교_1스트라이크_2볼() {
        String numStr = "312";
        String attackStr = "321";

        Result result = Judge.compare(numStr, attackStr);

        int strike = result.getStrikeCnt();
        int ball = result.getBallCnt();

        assertThat(strike).isEqualTo(1);
        assertThat(ball).isEqualTo(2);
    }

    @Test
    void 두_숫자_비교_2스트라이크() {
        String numStr = "312";
        String attackStr = "412";

        Result result = Judge.compare(numStr, attackStr);

        int strike = result.getStrikeCnt();
        int ball = result.getBallCnt();

        assertThat(strike).isEqualTo(2);
        assertThat(ball).isZero();
    }

    @Test
    void 두_숫자_비교_3볼() {
        String numStr = "312";
        String attackStr = "123";

        Result result = Judge.compare(numStr, attackStr);

        int strike = result.getStrikeCnt();
        int ball = result.getBallCnt();

        assertThat(strike).isZero();
        assertThat(ball).isEqualTo(3);
    }

    @Test
    void 두_숫자_비교_낫싱() {
        String numStr = "312";
        String attackStr = "456";

        Result result = Judge.compare(numStr, attackStr);

        int strike = result.getStrikeCnt();
        int ball = result.getBallCnt();

        assertThat(strike).isZero();
        assertThat(ball).isZero();
    }

    @Test
    void 두_숫자_비교_3스트라이크() {
        String numStr = "312";
        String attackStr = "312";

        Result result = Judge.compare(numStr, attackStr);

        int strike = result.getStrikeCnt();
        int ball = result.getBallCnt();

        assertThat(strike).isEqualTo(3);
        assertThat(ball).isZero();
    }

//    @Test
//    void 낫싱() {
//        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
//            mockRandoms
//                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
//                    .thenReturn(1, 3, 5);
//            running("246");
//            verify("낫싱");
//        }
//    }
//
//    @Test
//    void 게임종료_후_재시작() {
//        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
//            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
//                    .thenReturn(7, 1, 3)
//                    .thenReturn(5, 8, 9);
//            run("713", "1", "597", "589", "2");
//            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
//        }
//    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }
}
