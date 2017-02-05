package com.room414.homework1.gsd;

/**
 * Provides functionality to find GSD by binary Euclidean algorithm
 *
 * Created by alexander on 31/01/17.
 */
public class EuclideanAlgorithm {

    private EuclideanAlgorithm() {

    }

    /**
     * Finds GSD of a and b
     *
     * @return GSD of a and b
     */
    public static int findGsd(int a, int b) {
        return binaryGcdAlgorithm(Math.abs(a), Math.abs(b));
    }

    /**
     * Finds GSD of a and b
     *
     * <p>a and b should be positive</p>
     *
     * @param a positive int value
     * @param b positive int value
     * @return GSD of a and b
     */
    private static int binaryGcdAlgorithm(int a, int b) {
        if (a == 0 || b == 0) {
            return a | b;
        }

        if (a == b) {
            return a;
        }

        if (a == 1 || b == 1) {
            return 1;
        }

        if (((a & 0b1) == 0b0) && ((b & 0b1) == 0b0)) {
            return binaryGcdAlgorithm(a >> 1, b >> 1) << 1;
        }

        if (((a & 0b1) == 0b0) && ((b & 0b1) != 0b0)) {
            return binaryGcdAlgorithm(a >> 1, b);
        }

        if (((a & 0b1) != 0b0) && ((b & 0b1) == 0b0)) {
            return binaryGcdAlgorithm(a, b >> 1);
        }

        if ((((a & 0b1) != 0b0) && ((b & 0b1) != 0b0)) && (a > b)) {
            return binaryGcdAlgorithm((a - b) >> 1, b);
        }

        if ((((a & 0b1) != 0b0) && ((b & 0b1) != 0b0)) && (a < b)) {
            return binaryGcdAlgorithm((b - a) >> 1, a);
        }

        return 0;
    }
}
