package com.room414.counter;

/**
 * Created by alexander on 02/02/17.
 */
public class BitCounter {
    public static int byteBitCount() {
        byte number = ~0;
        return bitCount(number);
    }

    public static int shortBitCount() {
        short number = ~0;
        return bitCount(number);
    }

    public static int intBitCount() {
        int number = ~0;
        return bitCount(number);
    }

    public static int longBitCount() {
        long number = ~0L;
        return bitCount(number);
    }

    private static int bitCount(long number) {
        return (int) (number & -number);
    }
}
