package com.company.bitoperations.implementation;

/**
 * Provides functionality to changing bit value of int number
 *
 * Created by alexander on 31/01/17.
 */
public class BitChanger {

    /**
     * Mode of changing
     */
    public enum ChangeMode {
        /** set bit to 0*/
        ZERO,
        /** set bit to 1*/
        ONE
    }

    /**
     * Change in the variable pos bit by 1 or 0.
     *
     * @param number number that must be changed
     * @param pos index of changing bit
     * @param mode mode of changing:
     *             ZERO - to 0
     *             ONE - to 1
     * @return changed number
     * @throws IllegalArgumentException if pos not in diapason ({@code pos < 0 || pos >= Integer.SIZE})
     * @see Integer#SIZE
     */
    public static int changeBit(int number, int pos, ChangeMode mode) throws IllegalArgumentException {
        if (pos > Integer.SIZE) {
            throw new IllegalArgumentException(String.format("Pos must be less than %d. Got %d",
                    Integer.SIZE, pos));
        }

        if (pos < 0) {
            throw new IllegalArgumentException(String.format("Pos must be greater than or equal to %d. Got %d"
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
