package com.company.bitoperations.test;

import com.company.bitoperations.implementation.KaratsubaAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by alexander on 03/02/17.
 */
class KaratsubaAlgorithmTest {
    @Test
    void multiply() {
        String val1 = "1234";
        String val2 = "1234";
        String multiplication = "1522756";

        String result = KaratsubaAlgorithm.multiply(val1, val2);

        assertEquals(multiplication, result);
    }
}