package org.example.wiseSaying;

import java.util.Scanner;

public class Container {
    private static Scanner sc;

    public static Util util;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getSc() {
        return sc;
    }

    public static Util getUtil() {
        return util;
    }
}
