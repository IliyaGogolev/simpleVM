package com.simplevm.model;

public class Logger {

    private static boolean USE_LOG = false;

    public static void println(String text) {
        if (USE_LOG) System.out.println(text);
    }

    public static void println(int value) {
        if (USE_LOG) System.out.println(value);
    }
}
