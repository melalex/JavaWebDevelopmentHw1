package com.company.bitoperations.implementation.counter;

/**
 * Created by alexander on 02/02/17.
 */
public class BitCounter {
    public static int byteBitCount() {
        byte number = ~0;
        int count = 0;

        while (number != 0) {
            number >>>= 1;
            count++;
        }

        return count;
    }

    public static int shortBitCount() {
        short number = ~0;
        int count = 0;

        while (number != 0) {
            number >>>= 1;
            count++;
        }

        return count;
    }

    public static int intBitCount() {
        int number = ~0;
        int count = 0;

        while (number != 0) {
            number >>>= 1;
            count++;
        }

        return count;
    }

    public static int longBitCount() {
        long number = ~0L;
        int count = 0;

        while (number != 0) {
            number >>>= 1;
            count++;
        }

        return count;
    }
}
