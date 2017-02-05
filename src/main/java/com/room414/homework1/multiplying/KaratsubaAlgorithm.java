package com.room414.homework1.multiplying;

import java.util.Arrays;

/**
 * Provides functionality to find product of two integer values
 *
 * Created by alexander on 03/02/17.
 */
public class KaratsubaAlgorithm {
    private static final int NATIVE_LENGTH = 1;
    private static final int BASE = 10;
    private static final char SIGN_CHAR = '-';

    private KaratsubaAlgorithm() {

    }

    /**
     * Parses the string argument as array of digits in reverse order
     *
     * @param number string representation of number
     * @param size size of result array
     * @return array representation of number
     * @throws IllegalArgumentException if number contains non-numeric value
     */
    private static int[] arrayFromString(String number, int size) {
        int numberLength = number.length();
        int[] result = new int[size];
        int numericalValue;

        for (int i = 0; i < numberLength; i++) {
            numericalValue = Character.getNumericValue(number.charAt(i));
            if (numericalValue >= 0) {
                result[numberLength - i - 1] = numericalValue;
            } else {
                throw new  IllegalArgumentException(number.charAt(i) + " is not numeric value");
            }
        }

        return result;
    }

    /**
     * Multiply two integer values represented by string
     *
     * @param a first multiplier
     * @param b second multiplier
     * @return result of multiplying
     * @throws IllegalArgumentException if a or b contains non-numeric value
     */
    public static String multiply(String a, String b) {
        boolean isNegative = false;
        String unsignedA = a;
        String unsignedB = b;

        if (a.startsWith("-") && b.startsWith("-")) {
            unsignedA = a.substring(1);
            unsignedB = b.substring(1);
        } else if (a.startsWith("-")) {
            isNegative = true;
            unsignedA = a.substring(1);
        } else if (b.startsWith("-")) {
            isNegative = true;
            unsignedB = b.substring(1);
        }

        int maxSize = Math.max(unsignedA.length(), unsignedB.length());

        if ((maxSize & (maxSize - 1)) != 0) {
            maxSize = Integer.highestOneBit(maxSize) << 1;
        }

        int[] firstParameter = arrayFromString(unsignedA, maxSize);
        int[] secondParameter = arrayFromString(unsignedB, maxSize);

        int[] result = karatsubaMultiply(firstParameter, secondParameter);
        result = normalize(result);
        StringBuilder resultString = new StringBuilder();

        if (isNegative) {
            resultString.append(SIGN_CHAR);
        }

        int zeros = result.length - 1;
        while (result[zeros] == 0) {
            zeros--;
        }

        for (int i = zeros; i >= 0; i--) {
            resultString.append(result[i]);
        }

        return resultString.toString();
    }

    /**
     * Multiply two integer values using Karatsuba algorithm
     *
     * <p>Values should be represent as array of digits in reverse order without sign</p>
     *
     * @param a first multiplier
     * @param b second multiplier
     * @return result of multiplying
     */
    private static int[] karatsubaMultiply(int[] a, int[] b) {
        int length = a.length;
        int halfLength = length / 2;

        if (length <= NATIVE_LENGTH) {
            return nativeMultiply(a, b);
        }

        int[] result = new int[length * 2];

        int[] aLeft = Arrays.copyOfRange(a, 0, halfLength);
        int[] aRight = Arrays.copyOfRange(a, halfLength, length);
        int[] bLeft = Arrays.copyOfRange(b, 0, halfLength);
        int[] bRight = Arrays.copyOfRange(b, halfLength, length);
        int[] aLeftRight = new int[halfLength];
        int[] bLeftRight = new int[halfLength];

        for (int i = 0; i < halfLength; i++) {
            aLeftRight[i] = aLeft[i] + aRight[i];
            bLeftRight[i] = bLeft[i] + bRight[i];
        }

        int[] mult1 = karatsubaMultiply(aLeft, bLeft);
        int[] mult2 = karatsubaMultiply(aRight, bRight);
        int[] mult3 = karatsubaMultiply(aLeftRight, bLeftRight);

        for (int i = 0; i < length; i++) {
            mult3[i] -= mult1[i] + mult2[i];
        }

        System.arraycopy(mult1, 0, result, 0, length);
        System.arraycopy(mult2, 0, result, length, length);

        for (int i = halfLength; i < length + halfLength; i++) {
            result[i] += mult3[i - halfLength];
        }

        return result;
    }

    /**
     * Multiply two integer values using classic algorithm
     *
     * <p>Values should be represent as array of digits in reverse order without sign</p>
     *
     * @param a first multiplier
     * @param b second multiplier
     * @return unnormalized result of multiplying
     */
    private static int[] nativeMultiply(int[] a, int[] b) {
        int length = a.length;
        int[] result = new int[2 * length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result[i + j] += a[i] * b[j];
            }
        }

        return result;
    }

    /**
     *
     * @param result value to normalize
     * @return normalized value
     */
    private static int[] normalize(int[] result) {
        int[] normResult = Arrays.copyOf(result, result.length);

        for (int i = 0; i < normResult.length - 1; i++) {
            normResult[i + 1] += normResult[i] / BASE;
            normResult[i] = normResult[i] % BASE;
        }

        return normResult;
    }
}
