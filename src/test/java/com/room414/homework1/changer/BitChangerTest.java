package com.room414.homework1.changer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for BitChanger class
 *
 * Created by alexander on 31/01/17.
 */
class BitChangerTest {

    @Test
    void testSetToZeroNormalBehavior() {
        int number1 = 0b1100;
        int expectedResult1 = 0b1000;
        int pos1 = 2;

        int number2 = 0b1001;
        int expectedResult2 = 0b1000;
        int pos2 = 0;

        int result1 = BitChanger.clearBit(number1, pos1);
        int result2 = BitChanger.clearBit(number2, pos2);

        assert expectedResult1 == result1;
        assert expectedResult2 == result2;
    }

    @Test
    void testSetToOneNormalBehavior() {
        int number1 = 0b1000;
        int expectedResult1 = 0b1100;
        int pos1 = 2;

        int number2 = 0b1000;
        int expectedResult2 = 0b1001;
        int pos2 = 0;

        int result = BitChanger.setBit(number1, pos1);
        int result2 = BitChanger.setBit(number2, pos2);

        assert expectedResult1 == result;
        assert expectedResult2 == result2;
    }

    @Test
    void testPosLessThanTheLowerLimit() {
        int pos = -1;
        int number = 0;

        assertThrows(IllegalArgumentException.class,() -> BitChanger.setBit(number, pos));
        assertThrows(IllegalArgumentException.class,() -> BitChanger.clearBit(number, pos));
    }

    @Test
    void testPosMoreThanTheUpperLimit() {
        int pos = Integer.SIZE + 1;
        int number = 0;

        assertThrows(IllegalArgumentException.class, () -> BitChanger.setBit(number, pos));
        assertThrows(IllegalArgumentException.class, () -> BitChanger.setBit(number, Integer.SIZE));
        assertThrows(IllegalArgumentException.class, () -> BitChanger.clearBit(number, pos));
        assertThrows(IllegalArgumentException.class, () -> BitChanger.clearBit(number, Integer.SIZE));
    }
}