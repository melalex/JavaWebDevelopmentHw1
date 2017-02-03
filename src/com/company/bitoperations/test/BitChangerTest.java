package com.company.bitoperations.test;

import com.company.bitoperations.implementation.BitChanger;
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
        int pos1 = 3;

        int number2 = 0b1001;
        int expectedResult2 = 0b1000;
        int pos2 = 0;

        int result1 = BitChanger.changeBit(number1, pos1, BitChanger.ChangeMode.ZERO);
        int result2 = BitChanger.changeBit(number2, pos2, BitChanger.ChangeMode.ZERO);

        assert expectedResult1 == result1;
        assert expectedResult2 == result2;
    }

    @Test
    void testSetToOneNormalBehavior() {
        int number1 = 0b1000;
        int expectedResult1 = 0b1100;
        int pos1 = 3;

        int number2 = 0b1000;
        int expectedResult2 = 0b1001;
        int pos2 = 0;

        int result = BitChanger.changeBit(number1, pos1, BitChanger.ChangeMode.ONE);
        int result2 = BitChanger.changeBit(number2, pos2, BitChanger.ChangeMode.ONE);

        assert expectedResult1 == result;
        assert expectedResult2 == result2;
    }

    @Test
    void testPosLessThanTheLowerLimit() {
        int pos = -1;
        int number = 0;

        assertThrows(
                IllegalArgumentException.class,
                () -> BitChanger.changeBit(number, pos, BitChanger.ChangeMode.ONE)
        );
    }

    @Test
    void testPosMoreThanTheUpperLimit() {
        int pos = Integer.SIZE + 1;
        int number = 0;

        assertThrows(
                IllegalArgumentException.class,
                () -> BitChanger.changeBit(number, pos, BitChanger.ChangeMode.ONE)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> BitChanger.changeBit(number, Integer.SIZE, BitChanger.ChangeMode.ONE)
        );
    }
}