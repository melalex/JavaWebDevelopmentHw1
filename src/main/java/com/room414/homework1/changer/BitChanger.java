package com.room414.homework1.changer;


/**
 * Provides functionality to changing bit value of int number
 *
 * Created by alexander on 31/01/17.
 */
public class BitChanger {

    private BitChanger() {

    }

    /**
     * Change in the variable pos bit by.
     *
     * @param number number that must be changed
     * @param pos index of changing bit
     * @return changed number
     * @throws IllegalArgumentException if pos not in diapason ({@code pos < 0 || pos >= Integer.SIZE})
     * @see Integer#SIZE
     */
    public static int setBit(int number, int pos) {
        if (pos >= Integer.SIZE) {
            throw new IllegalArgumentException(String.format("Pos must be less than %d. Got %d",
                    Integer.SIZE, pos));
        }

        if (pos < 0) {
            throw new IllegalArgumentException(String.format("Pos must be greater than or equal to %d. Got %d", 0, pos));
        }

        return number | (1 << pos);
    }

    /**
     * Change in the variable pos bit by 0.
     *
     * @param number number that must be changed
     * @param pos index of changing bit
     * @return changed number
     * @throws IllegalArgumentException if pos not in diapason ({@code pos < 0 || pos >= Integer.SIZE})
     * @see Integer#SIZE
     */
    public static int clearBit(int number, int pos) {
        if (pos >= Integer.SIZE) {
            throw new IllegalArgumentException(String.format("Pos must be less than %d. Got %d",
                    Integer.SIZE, pos));
        }

        if (pos < 0) {
            throw new IllegalArgumentException(String.format("Pos must be greater than or equal to %d. Got %d", 0, pos));
        }

        return number & ~(1 << pos);
    }
}
