package com.company.bitoperations.implementation;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 03/02/17.
 */
public class KaratsubaAlgorithm {
    private static final int NATIVE_LENGTH = 1;

    private static List<Integer> arrayFromString(String number, int size) throws IllegalArgumentException{
        int numberLength = number.length();
        ArrayList<Integer> result = new ArrayList<>(size);
        int numericalValue;

        for (int i = 0; i < numberLength; i++) {
            numericalValue = Character.getNumericValue(number.charAt(i));
            if (numericalValue >= 0) {
                result.set(numberLength - i - 1, numericalValue);
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
        } else if (maxSize % 2 != 0) {
            maxSize++;
        }

        List<Integer> firstParameter = arrayFromString(a, maxSize);
        List<Integer> secondParameter = arrayFromString(b, maxSize);

        List<Integer> result = karatsubaMultiply(firstParameter, secondParameter);
        StringBuilder resultString = new StringBuilder();

        for (int i = result.size() - 1; i >= 0; i--) {
            resultString.append(result.get(i));
        }

        return resultString.toString();
    }

    private static List<Integer> karatsubaMultiply(@NotNull List<Integer> a, @NotNull List<Integer> b) {
        int numberLength = a.size();
        int halfLength = numberLength / 2;

        if (numberLength <= NATIVE_LENGTH) {
            return nativeMultiply(a, b);
        }

        List<Integer> result = new ArrayList<>(numberLength * 2);

        List<Integer> aLeft = a.subList(0, halfLength);
        List<Integer> aRight = a.subList(halfLength, numberLength);
        List<Integer> bLeft = b.subList(0, halfLength);
        List<Integer> bRight = b.subList(halfLength, numberLength);
        List<Integer> aLeftRight = new ArrayList<>(halfLength);
        List<Integer> bLeftRight = new ArrayList<>(halfLength);

        for (int i = 0; i < halfLength; i++) {
            aLeftRight.set(i, aLeft.get(i) + aRight.get(i));
            bLeftRight.set(i, bLeft.get(i) + bRight.get(i));
        }

        List<Integer> mult1 = karatsubaMultiply(aLeft, bLeft);
        List<Integer> mult2 = karatsubaMultiply(aRight, bRight);
        List<Integer> mult3 = karatsubaMultiply(aLeftRight, bLeftRight);



        return result;
    }

    private static List<Integer> nativeMultiply(@NotNull List<Integer> a, @NotNull List<Integer> b) {
        int length = a.size();

        for (int)

        return new ArrayList<>()
    }
}
