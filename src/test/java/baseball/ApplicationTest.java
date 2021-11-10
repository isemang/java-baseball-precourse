package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Array;
import java.util.*;

import static baseball.Numbers.LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    int[] array;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @BeforeEach
    void beforeEach() {
        Numbers numbers = new Numbers();
        array = numbers.getNumbers();
        super.setUp();
    }
    
    @Test
    void 랜덤으로_3자리_숫자를_뽑는다() {
        for (int num : array) {
            System.out.print(num);
        }
    }

    @Test
    void 뽑은_3자리_숫자가_중복되지_않는지_확인한다() {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        assertThat(set.size()).isEqualTo(LENGTH);
    }

    @Test
    void 뽑은_숫자가_3자리가_맞는지_확인한다() {
        assertThat(array.length).isEqualTo(LENGTH);
    }

    @Test
    void 공격하는_숫자를_입력받고_저장하는_객체_생성() {
        Attacker attacker = new Attacker();
        assertThat(attacker).isNotNull();
    }

    @Test
    void 세자리를_입력받으면_정상() {

    }

    @Test
    void 네자리를_입력받으면_비정상_재입력을_요청한다() {
        
    }

    @Test
    void 세자리_숫자_입력_받은_후_저장_잘되었는지_확인() {

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
