package nextstep.utils;

import java.util.Scanner;

public class Scan {
    private final Scanner sc;

    public Scan() {
        sc = new Scanner(System.in);
    }

    public int scanValue() {
        return sc.nextInt();
    }

    public void closeScan() {
        sc.close();
    }
}
