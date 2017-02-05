package com.room414.multiplying;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by alexander on 03/02/17.
 */
class KaratsubaAlgorithmTest {
    @Test
    void multiplyEvenCount() {
        String val1 = "1234";
        String val2 = "1234";
        String multiplication = "1522756";

        String result = KaratsubaAlgorithm.multiply(val1, val2);

        assertEquals(multiplication, result);
    }

    @Test
    void multiplyOddCount() {
        String val1 = "12345";
        String val2 = "12345";
        String multiplication = "152399025";

        String result = KaratsubaAlgorithm.multiply(val1, val2);

        assertEquals(multiplication, result);
    }

    @Test
    void multiplyTwoNegative() {
        String val1 = "-1234";
        String val2 = "-1234";
        String multiplication = "1522756";

        String result = KaratsubaAlgorithm.multiply(val1, val2);

        assertEquals(multiplication, result);
    }

    @Test
    void multiplyOneNegative() {
        String val1 = "-1234";
        String val2 = "1234";
        String multiplication = "-1522756";

        String result = KaratsubaAlgorithm.multiply(val1, val2);

        assertEquals(multiplication, result);
    }

    @Test
    void multiplyThrows1() {
        String val1 = "12@45";
        assertThrows(IllegalArgumentException.class, () -> KaratsubaAlgorithm.multiply(val1, val1));
    }
}