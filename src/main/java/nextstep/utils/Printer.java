package nextstep.utils;

/**
 * 프린터 : print하고 싶은 string을 보여줌
 */
public class Printer {
    private Printer() {
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printNoLineBreak(String str) {
        System.out.print(str);
    }
}