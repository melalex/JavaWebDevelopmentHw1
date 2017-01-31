package com.company.bitoperations.implementation;

/**
 * Created by alexander on 31/01/17.
 */
public class BitChanger {

    public enum ChangeMode {ZERO, ONE}

    public int changeBit(int number, int pos, ChangeMode mode) throws IllegalArgumentException {
        if (pos > Integer.SIZE) {
            throw new IllegalArgumentException(String.format("Pos must be less than %d. Got %d",
                    Integer.SIZE, pos));
        }

        if (pos < 0) {
            throw new IllegalArgumentException(String.format("Pos must be greater than %d. Got %d"
                    , 0, pos));
        }

        int bitmask = 1 << pos;
        int result = 0;

        if (mode == ChangeMode.ZERO) {
            bitmask = ~bitmask;
            result = number & bitmask;
        } else if (mode == ChangeMode.ONE) {
            result = number | bitmask;
        }

        return result;
    }
}
