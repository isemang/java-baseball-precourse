package nextstep.utils;

/**
 * 프린터 : print하고 싶은 string을 보여줌
 */
public class Printer {
    private Printer() {
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void print(PrintType printType) {
        System.out.print(printType.getMessage());
    }

    public static void println(PrintType printType) {
        System.out.println(printType.getMessage());
    }
}