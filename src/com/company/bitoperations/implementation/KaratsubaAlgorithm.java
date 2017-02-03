package com.company.bitoperations.implementation;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * Created by alexander on 03/02/17.
 */
public class KaratsubaAlgorithm {
    private static final int NATIVE_LENGTH = 1;
    private static final int BASE = 10;

    private static int[] arrayFromString(String number, int size) throws IllegalArgumentException{
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

    public static String multiply(@NotNull String a, @NotNull String b) throws IllegalArgumentException {
        int maxSize = Math.max(a.length(), b.length());
        if (maxSize == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Argument is too big");
        } else if ((maxSize & (maxSize - 1)) != 0) {
            maxSize = Integer.highestOneBit(maxSize) << 1;
        }

        int[] firstParameter = arrayFromString(a, maxSize);
        int[] secondParameter = arrayFromString(b, maxSize);

        int[] result = karatsubaMultiply(firstParameter, secondParameter);
        result = normalize(result);
        StringBuilder resultString = new StringBuilder();

        if (result[result.length - 1] != 0) {
            resultString.append(result[result.length - 1]);
        }

        for (int i = result.length - 2; i >= 0; i--) {
            resultString.append(result[i]);
        }

        return resultString.toString();
    }

    private static int[] karatsubaMultiply(@NotNull int[] a, @NotNull int[] b) {
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

    private static int[] nativeMultiply(@NotNull int[] a, @NotNull int[] b) {
        int length = a.length;
        int[] result = new int[2 * length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result[i + j] += a[i] * b[j];
            }
        }

        return result;
    }

    private static int[] normalize(@NotNull int[] result) {
        int[] normResult = Arrays.copyOf(result, result.length);

        for (int i = 0; i < normResult.length - 1; i++) {
            normResult[i + 1] += normResult[i] / BASE;
            normResult[i] = normResult[i] % BASE;
        }

        return normResult;
    }
}
