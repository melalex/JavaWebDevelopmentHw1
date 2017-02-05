package com.room414.homework1.counter;

/**
 * Created by alexander on 02/02/17.
 */
public class BitCounter {

    private BitCounter() {

    }

    public static int byteBitCount() {
        byte number = 1;
        int count = 1;

        while ((number <<= 1) != 0) {
            count ++;
        }

        return count;
    }

    public static int shortBitCount() {
        short number = 1;
        int count = 1;

        while ((number <<= 1) != 0) {
            count ++;
        }

        return count;
    }

    public static int intBitCount() {
        int number = 1;
        int count = 1;

        while ((number <<= 1) != 0) {
            count ++;
        }

        return count;
    }

    public static int longBitCount() {
        long number = 1;
        int count = 1;

        while ((number <<= 1) != 0) {
            count ++;
        }

        return count;
    }
}
